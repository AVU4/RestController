package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import web.lab.Entities.User;
import web.lab.Requests.RequestUser;
import web.lab.Responses.ResponseUser;
import web.lab.Security.TokenProvider;
import web.lab.Services.UserService;
import web.lab.Validation.UserValidation;

import java.io.IOException;


@RestController
public class UserController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidation userValidation;


    //Токен при регистрации пуст
    @PostMapping("/users")
    public @ResponseBody ResponseUser registration(@RequestBody RequestUser request){
        String nickname = request.getNickname();
        String password = request.getPassword();
        String validationResult = userValidation.validate(nickname, password);
        if (!validationResult.equals("OK")) {
            return new ResponseUser(validationResult, "YES");
        }else{
            User user = new User(nickname, passwordEncoder.encode(password), null);
            userService.addUser(user);
            return new ResponseUser("Регистрация прошла успешно", "NO");
        }
    }

    @PostMapping("/login")
    public @ResponseBody ResponseUser login(@RequestBody RequestUser request) {
        String nickname = request.getNickname();
        String password = request.getPassword();
        String validationResult = userValidation.validate(nickname, password);
        if (validationResult.startsWith("Пользователь")){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNickname(), request.getPassword()));
            User currentUser = userService.findUserByNickname(request.getNickname());

            if (currentUser == null) {
                throw new UsernameNotFoundException("User not found");
            }
            String token = tokenProvider.resolveToken(request.getNickname());
            return new ResponseUser(token, "NO");
        }else{
            return new ResponseUser(validationResult.equals("OK") ? "Пользователь с таким логином не зарегистрирован": validationResult, "YES");
        }

    }


    @PostMapping("/exit")
    public @ResponseBody ResponseUser logout(){
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByNickname(authentication.getName());
        user.setAuthToken(null);
        userService.addUser(user);
        return new ResponseUser("Пользователь вышел из системы", "NO");
    }

    @GetMapping("/access")
    public @ResponseBody ResponseUser checkAccess(@RequestParam String mode){
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        String nickname = authentication.getName();
        if (mode.equals("main")){
            if (nickname.equals("anonymousUser"))
                return new ResponseUser("", "YES");
            else
                return new ResponseUser("", "NO");
        }else if (mode.equals("login") || mode.equals("registration")){
            if (nickname.equals("anonymousUser"))
                return new ResponseUser("", "NO");
            else
                return new ResponseUser("", "YES");
        }else{
            return new ResponseUser("", "YES");
        }
    }
}

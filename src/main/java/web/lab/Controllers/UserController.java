package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @CrossOrigin
    @PostMapping("/login")
    public @ResponseBody ResponseUser login(@RequestBody RequestUser request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNickname(), request.getPassword()));
        User currentUser = userService.findUserByNickname(request.getNickname());

        if (currentUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String token = tokenProvider.resolveToken(request.getNickname());
        return new ResponseUser(token, "NO");
    }
}

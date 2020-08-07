package web.lab.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import web.lab.Entities.User;
import web.lab.Requests.RequestUser;
import web.lab.Responses.ResponseUser;
import web.lab.Services.UserService;
import web.lab.Validation.UserValidation;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidation userValidation;

    @PostMapping("/users")
    public @ResponseBody ResponseUser registration(@RequestBody RequestUser request){
        String nickname = request.getNickname();
        String password = request.getPassword();
        String validationResult = userValidation.validate(nickname, password);
        if (validationResult.equals("OK")) {
            userService.addUser(new User(nickname, password));
            return new ResponseUser("Регистрация прошла успешна","NO");
        }else{
            return new ResponseUser(validationResult, "YES");
        }
    }
}

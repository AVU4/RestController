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

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public @ResponseBody ResponseUser registration(@RequestBody RequestUser request){
        String nickname = request.getNickname();
        String password = request.getPassword();
        userService.addUser(new User(nickname, password));
        return new ResponseUser("Ok", "NO");
    }
}

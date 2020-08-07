package web.lab.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.lab.Entities.User;
import web.lab.Services.UserService;

import javax.persistence.EntityNotFoundException;

@Service
public class UserValidation {

    @Autowired
    UserService userService;

    public String validate(String nickname, String password){
        try {
            if (nickname == null || password == null)
                return "Одно или оба поля пустые.";
            User user = userService.findUserByNickname(nickname);
            if (user == null)
                return "OK";
            else
                return "Пользователь " + nickname + " уже зарегистрирован.";
        }catch (EntityNotFoundException e){
            return "OK";
        }
    }
}

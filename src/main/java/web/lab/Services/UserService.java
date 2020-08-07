package web.lab.Services;

import org.springframework.stereotype.Service;
import web.lab.Entities.User;


public interface UserService {

    User addUser(User user);
    User findUserByNickname(String nickname);
}

package web.lab.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import web.lab.Entities.User;
import web.lab.Repositories.UserRepository;
import web.lab.Services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}

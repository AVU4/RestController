package web.lab.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.lab.Entities.User;
import web.lab.Repositories.UserRepository;
import web.lab.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findUserByNickname(String nickname) {
        return userRepository.findOneByNickname(nickname);
    }

    @Override
    public User findUserByAuthToken(String token) {
        return userRepository.findByAuthTokenEquals(token);
    }
}

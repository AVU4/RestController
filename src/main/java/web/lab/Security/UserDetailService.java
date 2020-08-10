package web.lab.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.lab.Entities.User;
import web.lab.Services.UserService;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return find(s);
    }

    public User find(String nickname){
        return userService.findUserByNickname(nickname);
    }

    public User findByAuthToken(String token){
        return userService.findUserByAuthToken(token);
    }

    public User save(User user){
        return userService.addUser(user);
    }
}

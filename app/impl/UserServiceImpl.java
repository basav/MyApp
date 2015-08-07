package impl;

import com.google.inject.Inject;
import models.User;
import repository.UserRepository;
import services.UserService;

import java.util.List;

/**
 * Created by Basav Nagur.
 */
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        User dbUser = userRepository.getUser(user.login);
        if (dbUser != null) {
            dbUser.login = user.login;
            dbUser.name = user.name;
            dbUser.public_repos = user.public_repos;
            userRepository.update(dbUser);
        }else{
            userRepository.create(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}

package services;

import models.User;

import java.util.List;

/**
 * Created by Basav Nagur.
 */
public interface UserService {

    void save(User user);

    List<User> getAllUsers();

}

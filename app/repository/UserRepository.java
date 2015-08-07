package repository;

import models.User;

import java.util.List;

/**
 * Created by Basav Nagur.
 */
public interface UserRepository {

    User getUser(String login);

    void update(User user);

    void create(User user);

    List<User> getAll();
}
package impl;

import com.avaje.ebean.Ebean;
import models.User;
import repository.UserRepository;

import java.util.List;

/**
 * Created by Basav Nagur.
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void create(User user) {
        Ebean.save(user) ;
    }

    @Override
    public User getUser(String login) {
        return Ebean.find(User.class).where().eq("login",login).findUnique();
    }

    @Override
    public List<User> getAll() {
        return Ebean.find(User.class).findList();
    }

    @Override
    public void update(User user) {
        Ebean.update(user);
    }
}

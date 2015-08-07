package controllers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.GithubService;
import services.UserService;
import views.html.list;

import java.util.List;

/**
 * Created by Basav Nagur.
 */
@Singleton
public class Users extends Controller {

    @Inject
    UserService userService;

    @Inject
    GithubService githubService;

    public Result find(String username) {
        User user = githubService.find(username);

        if (user != null){
            userService.save(user);
        }
        return redirect(routes.Users.list());
    }

    public Result list(){
        List<User> userList = userService.getAllUsers();
        return ok(list.render(userList));
    }
}

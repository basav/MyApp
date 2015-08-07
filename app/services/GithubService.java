package services;

import models.User;

/**
 * Created by Basav Nagur on 8/7/15.
 */
public interface GithubService {
    User find(String username);
}

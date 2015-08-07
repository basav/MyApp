package components;

import com.google.inject.AbstractModule;
import impl.GithubServiceImpl;
import impl.UserRepositoryImpl;
import impl.UserServiceImpl;
import repository.UserRepository;
import services.GithubService;
import services.UserService;

/**
 * Created by Basav Nagur.
 */
public class ComponentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GithubService.class).to(GithubServiceImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
        bind(UserRepository.class).to(UserRepositoryImpl.class);
    }
}

package services;

import impl.UserServiceImpl;
import models.User;
import org.junit.Test;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Basav Nagur
 */
public class UserServicesTest {

    @Test
    public void testSaveUser(){
        User user = new User();
        user.id = "100";
        user.login = "basav";
        user.public_repos = "10";
        user.name = "Basav Nagur";

        UserRepository repositoryMock = mock(UserRepository.class);

        UserService userService = new UserServiceImpl(repositoryMock);
        when(repositoryMock.getUser(user.login)).thenReturn(null);
        doNothing().when(repositoryMock).create(user);

        userService.save(user); // actual method

        verify(repositoryMock).getUser(user.login);
        verify(repositoryMock).create(user);

    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.id = "100";
        user.login = "basav";
        user.public_repos = "10";
        user.name = "Basav Nagur";

        UserRepository repositoryMock = mock(UserRepository.class);

        UserService userService = new UserServiceImpl(repositoryMock);
        when(repositoryMock.getUser(user.login)).thenReturn(user);
        doNothing().when(repositoryMock).update(user);

        userService.save(user); // actual method

        verify(repositoryMock).getUser(user.login);
        verify(repositoryMock).update(user);
    }

    @Test
    public void testGetAllUsers(){
        List<User> userList = new ArrayList<User>();

        User user1 = new User();
        user1.id = "100";
        user1.login = "basav";
        user1.public_repos = "10";
        user1.name = "Basav Nagur";

        User user2 = new User();
        user2.id = "200";
        user2.login = "raj";
        user2.public_repos = "20";
        user2.name = "Rajah H";

        userList.add(user1);
        userList.add(user2);

        UserRepository repositoryMock = mock(UserRepository.class);

        UserService userService = new UserServiceImpl(repositoryMock);
        when(repositoryMock.getAll()).thenReturn(userList);


        List<User> dbList = userService.getAllUsers(); // actual method

        verify(repositoryMock).getAll();
    }
}

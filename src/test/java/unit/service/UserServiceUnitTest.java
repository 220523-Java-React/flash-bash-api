package unit.service;


import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

// what type of operations??
//          CRUD operations
//              getAll
//              getById
//              create
//              update -> ?
//              delete
public class UserServiceUnitTest {

    @Test
    public void whenGivenAUserObjectCreateUserDoesNotThrowAnException(){
        UserService service = new UserService();
        User user = new User();

        Assertions.assertDoesNotThrow(() -> service.createUser(user));
    }

    @Test
    public void whenGivenAUserObjectCreateUserReturnsTrue(){
        UserService service = new UserService();
        User user = new User();

        Assertions.assertTrue(service.createUser(user));
    }

    @Test
    public void whenGetAllUsersIsCalledReturnsAllUsers(){
        List<User> users = new ArrayList<>();
        UserService service = new UserService(users);

        List<User> result = service.getAllUsers();
        Assertions.assertEquals(users, result);
    }

    @Test
    public void whenGivenValidIdGetUserByIdReturnsUserWithThatId(){
        List<User> mockList = Mockito.mock(List.class);
        User user = new User();
        user.setId(1);
        UserService service = new UserService(mockList);

        Mockito.when(mockList.size()).thenReturn(1);
        Mockito.when(mockList.get(0)).thenReturn(user);

        User result = service.getUserById(1);
        Assertions.assertEquals(user, result);
    }

    @Test
    public void whenGivenValidIdDeleteUserByIdReturnsTrue(){
        List<User> mockList = Mockito.mock(List.class);
        UserService service = new UserService(mockList);
        User user = new User();
        user.setId(1);

        Mockito.when(mockList.size()).thenReturn(1);
        Mockito.when(mockList.get(0)).thenReturn(user);
        Mockito.when(mockList.remove(0)).thenReturn(user);

        Assertions.assertTrue(service.deleteUserById(1));
    }


}

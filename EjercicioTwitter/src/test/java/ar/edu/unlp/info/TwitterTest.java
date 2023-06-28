package ar.edu.unlp.info;

import ar.edu.unlp.info.exceptions.UserNullOnCreationException;
import ar.edu.unlp.info.exceptions.UserScreenNameAlreadyExistsException;
import ar.edu.unlp.info.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {

    private final String screenName = "Pepe";


    @Test
    void createUserTest() throws UserScreenNameAlreadyExistsException, UserNullOnCreationException {
        Twitter twitter = new Twitter();
        User test = new User(screenName);
        twitter.createUser(test);
        assertEquals(twitter.getUsers().get(screenName),test);
    }

    @Test
    void createUserTwiceExceptionTest() throws UserScreenNameAlreadyExistsException, UserNullOnCreationException {
        Twitter twitter = new Twitter();
        User test = new User(screenName);
        twitter.createUser(test);
        assertThrows(UserScreenNameAlreadyExistsException.class,() -> twitter.createUser(test));
    }

    @Test
    void createUserNullExceptionTest() throws UserScreenNameAlreadyExistsException, UserNullOnCreationException {
        Twitter twitter = new Twitter();
        assertThrows(UserNullOnCreationException.class,() -> twitter.createUser(null));
    }

    @Test
    void deleteUser() {
    }

    @Test
    void testDeleteUser() {
    }
}
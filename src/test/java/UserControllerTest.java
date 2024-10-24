import org.junit.jupiter.api.Test;
import org.kromee.App;
import org.kromee.controller.UserController;
import org.kromee.model.Role;
import org.kromee.model.User;
import org.kromee.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = App.class)

public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Test User");
        userDto.setEmail("test@example.com");
        userDto.setPassword("password");
        userDto.setRole(Role.USER);


        ResponseEntity<User> responseEntity = userController.createUser(userDto);

        assertEquals(200, responseEntity.getStatusCodeValue());

        User createdUser = responseEntity.getBody();
        assertNotNull(createdUser);
        assertEquals(userDto.getName(), createdUser.getName());
    }
}
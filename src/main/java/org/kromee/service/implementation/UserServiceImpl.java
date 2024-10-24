package org.kromee.service.implementation;
import org.kromee.model.Role;
import org.kromee.model.User;
import org.kromee.model.dto.UserDto;
import org.kromee.persistence.UserDao;
import org.kromee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private List<Role> allowedRoles = Arrays.asList(Role.ADMIN, Role.USER);

    public UserServiceImpl(UserDao userDao) {
    }

    @Override
    public User createUser(UserDto userDto) {
        if (!allowedRoles.contains(userDto.getRole())){
            throw new IllegalArgumentException("Rol no permitido: " + userDto.getRole());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        String hashedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(userDto.getRole());

        return userDao.saveUser(user);
    }

    @Override
    public User modifyUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public User adminUser(User user) {
        return null;
    }
}

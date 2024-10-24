package org.kromee.service;

import org.kromee.model.User;
import org.kromee.model.dto.UserDto;

public interface UserService {

    User createUser(UserDto userDto);

    User modifyUser(User user);
    User deleteUser(User user);
    User adminUser(User user);

}

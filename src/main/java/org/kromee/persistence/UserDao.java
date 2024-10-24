package org.kromee.persistence;

import org.kromee.model.User;

public interface UserDao {

    User saveUser(User user);

    User findUserByEmail(String email);

    User loadUser(Long id);
}

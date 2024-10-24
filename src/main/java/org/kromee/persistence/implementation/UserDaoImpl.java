package org.kromee.persistence.implementation;
import org.kromee.model.User;
import org.kromee.persistence.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Repository
@Service
public class UserDaoImpl implements UserDao {
    private static final Map<Long, User> userRepository = new HashMap<>();
    long id = 1;


    @Override
    public User saveUser(User user) {
        user.setId(this.id);
        this.id++;
        userRepository.put(user.getId(), user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User loadUser(Long id) {
        return null;
    }
}
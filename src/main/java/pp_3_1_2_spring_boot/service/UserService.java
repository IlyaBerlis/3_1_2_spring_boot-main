package pp_3_1_2_spring_boot.service;

import org.springframework.stereotype.Service;
import pp_3_1_2_spring_boot.dao.UserDAO;
import pp_3_1_2_spring_boot.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserById(long id) {
        return userDAO.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userDAO.save(user);
    }

    public void removeUser(long id) {
        userDAO.deleteById(id);
    }

    public void updateUser(User user) {
        userDAO.save(user);
    }
}
package pp_3_1_2_spring_boot.service;

import pp_3_1_2_spring_boot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}

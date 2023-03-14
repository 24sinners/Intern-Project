package data.user_info.service;

import data.user_info.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUserById(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
}

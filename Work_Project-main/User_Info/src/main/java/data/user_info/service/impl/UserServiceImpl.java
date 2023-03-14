package data.user_info.service.impl;

import data.user_info.exception.ResourceNotFoundException;
import data.user_info.model.User;
import data.user_info.repository.UserRepository;
import data.user_info.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User", "Id","id"));
    }

    @Override
    public User updateUser(User user, long id) {
        //we need to check whether user with given id is exist in DB or not
        User existingUser = userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User", "Id","id"));

       existingUser.setUser_id(user.getUser_id());
       existingUser.setUser_image(user.getUser_image());
       existingUser.setUser_name(user.getUser_name());
       existingUser.setPhone_no(user.getPhone_no());
       existingUser.setEmail(user.getEmail());
       existingUser.setAddress(user.getAddress());
       existingUser.setTownship(user.getTownship());

        //save existing employee to DB
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
       userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id",id));
       userRepository.deleteById(id);
    }
}

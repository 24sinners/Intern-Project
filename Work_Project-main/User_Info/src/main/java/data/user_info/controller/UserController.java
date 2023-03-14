package data.user_info.controller;


import data.user_info.model.User;
import data.user_info.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User>saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

    }
    //build get employee REST API
    //http://localhost:8080/api/employees/1
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public ResponseEntity<User>getUserById(@PathVariable("id") long userid){
        return new ResponseEntity<>(userService.getUserById(userid),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable ("id") long userId, @RequestBody User user){
        userService.updateUser(user,userId);

        return new ResponseEntity<String>("User Updated Successfully!.",HttpStatus.OK);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") long userid){
        userService.deleteUser(userid);
        return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);

    }


}

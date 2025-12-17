package com.library.collegecompanionbackend.controller;

import com.library.collegecompanionbackend.dto.GetandPostUserDTO;
import com.library.collegecompanionbackend.model.User;
import com.library.collegecompanionbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public GetandPostUserDTO getUser(@PathVariable Long id){
        return userService.getID(id);
    }

    @PostMapping()
    public GetandPostUserDTO createUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @PutMapping("/{id}")
    public GetandPostUserDTO updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


}

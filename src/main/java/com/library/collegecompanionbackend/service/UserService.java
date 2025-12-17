package com.library.collegecompanionbackend.service;

import com.library.collegecompanionbackend.dto.GetandPostUserDTO;
import com.library.collegecompanionbackend.model.User;
import com.library.collegecompanionbackend.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public GetandPostUserDTO getID(Long id) {
        User user1 = userRepo.findById(Math.toIntExact(id)).orElseThrow(()->new RuntimeException("User not found!"));
        return (new GetandPostUserDTO(user1.getName(),user1.getId(),user1.getEmail(),user1.getRole()));
    }

    public GetandPostUserDTO postUser(User user) {
        User user2 = userRepo.save(user);
        return (new GetandPostUserDTO(user2.getName(),user2.getId(),user2.getEmail(),user2.getRole()));
    }

    public GetandPostUserDTO updateUser(Long id, User user) {
        User user2 = userRepo.findById(Math.toIntExact(id)).orElseThrow(()->new RuntimeException("User not registered, can't be updated"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setRole(user.getRole());
        user2 = userRepo.save(user2);
        return new GetandPostUserDTO(user2.getName(),user2.getId(),user2.getEmail(),user2.getRole());

    }

    public void deleteUser(Long id) {
        User user2 = userRepo.findById(Math.toIntExact(id)).orElseThrow(()->new RuntimeException("User not registered,can't be deleted"));
        userRepo.delete(user2);
    }
}

package com.library.collegecompanionbackend.repository;

import com.library.collegecompanionbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}

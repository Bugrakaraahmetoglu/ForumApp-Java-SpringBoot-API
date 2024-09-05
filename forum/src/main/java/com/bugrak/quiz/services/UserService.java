package com.bugrak.quiz.services;

import com.bugrak.quiz.entities.User;
import com.bugrak.quiz.repository.UserRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepositoy userRepositoy;

    public UserService(UserRepositoy userRepositoy) {
        this.userRepositoy = userRepositoy;
    }


    public List<User> getAllUsers() {
        return userRepositoy.findAll();
    }

    public User saveOneuser(User newUser) {
        return userRepositoy.save(newUser);
    }

    public User findByUserId(int userId) {
        return userRepositoy.findById(userId).orElse(null);
    }

    public User updateOneUser(int userId, User updatedUser) {
        Optional<User> user = userRepositoy.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setPassword(updatedUser.getPassword());
           userRepositoy.save(existingUser);
           return existingUser;
        }else {
            return null;
        }
    }
}

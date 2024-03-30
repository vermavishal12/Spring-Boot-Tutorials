package com.example.todocrud.services;

import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public Users getUserById (Long userId){
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public Users addUser(Users user){
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


    public void updateUser(Users user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }
        else{
            throw new RuntimeException("User Not found");
        }
    }

}

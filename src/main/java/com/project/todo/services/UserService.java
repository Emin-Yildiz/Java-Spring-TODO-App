package com.project.todo.services;

import com.project.todo.entities.User;
import com.project.todo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() { // tüm userları getirmek için kullanıcaz
        return userRepository.findAll();
    }

    public User getUserById(Long id) { // id'ye göre user getirmek için kullanıcaz
        return userRepository.findById(id).get();
    }

    public User createUser(User user) { // user oluşturmak için kullanıcaz
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User newUser) { // user güncellemek için kullanıcaz
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){ // user var mı yok mu kontrolü burada yapılıyor.
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else {
            return null;
        }
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}

package com.contact.api.service;


import com.contact.api.entity.User;
import com.contact.api.forms.SignupForm;
import com.contact.api.forms.UserUpdate;
import com.contact.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User createUser(SignupForm signupForm) {
        User user = User.getUserForSignUp(signupForm);
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->{return new NoSuchElementException();
        });
    }

    public User updateUser(UserUpdate updateUser) {
        User user = userRepository.findById(updateUser.getUserId()).orElseThrow(()->{return new NoSuchElementException();
        });
        user.setUserName(updateUser.getUserName());
        user.setEmailId(updateUser.getEmailId());
        user.setPhoneNo(updateUser.getPhone());
       return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean isExist=userRepository.existsById(userId);
        if(isExist){
            userRepository.deleteById(userId);
        } else {
            throw new NoSuchElementException("User Id not exist "+userId);
        }
    }
}

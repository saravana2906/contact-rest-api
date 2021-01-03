package com.contact.api.controller;


import com.contact.api.entity.User;

import com.contact.api.forms.SignupForm;
import com.contact.api.forms.UserUpdate;
import com.contact.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    private Page<User> getAllUsers(Pageable pageable){
return userService.getAllUsers(pageable);
    }

    @GetMapping("/{userId}")
    private User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private User createUser(@RequestBody @Validated SignupForm signupForm){
        return userService.createUser(signupForm);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private User updateUser(@RequestBody @Validated UserUpdate user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }


}

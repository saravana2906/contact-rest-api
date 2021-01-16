package com.contact.api.controller;


import com.contact.api.dto.Pageutil;
import com.contact.api.entity.User;

import com.contact.api.exception.ClientRequestException;
import com.contact.api.forms.SignupForm;
import com.contact.api.forms.UserUpdate;
import com.contact.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    private Page<User> getAllUsers(Pageutil pageable){
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/{userId}")
    private User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private User createUser(@RequestBody @Validated SignupForm signupForm, @CurrentSecurityContext SecurityContext securitycontext) throws ClientRequestException {
        System.out.println(securitycontext.getAuthentication());
        Jwt principal = (Jwt) securitycontext.getAuthentication().getPrincipal();
        if(!signupForm.getEmailId().equals((String)principal.getClaim("email"))){
            throw new ClientRequestException("Access Denied Email id not matching with token");
        }
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

    @GetMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    private User signinUser(@AuthenticationPrincipal Jwt jwt){
        String emailId = jwt.getClaim("email");
        return userService.getUserByEmail(emailId);
    }


}

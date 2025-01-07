package com.tm.controller;

import com.tm.entities.UserEntity;
import com.tm.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/details")
    public ResponseEntity<UserEntity> userDetails() {
        System.out.println("Step-1 User Details ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userService.findByUsername(authentication.getName());
        user.setPassword("");
        System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

            return ResponseEntity.status(HttpStatus.OK).body(user);

    }

}

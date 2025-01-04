package com.tm.controller;

import com.tm.dtos.SignUpReqDto;
import com.tm.entities.UserEntity;
import com.tm.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/details")
    public ResponseEntity<UserEntity> userDetails() {
        System.out.println("2 Step User Details ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userServiceImpl.findByUsername(authentication.getName());
        System.out.println(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

            return ResponseEntity.status(HttpStatus.OK).body(user);

    }

}

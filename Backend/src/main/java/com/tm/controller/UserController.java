package com.tm.controller;

import com.tm.dtos.signUpReqDto;
import com.tm.entities.userEntity;
import com.tm.service.userServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private userServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<String> userRegistration(@RequestBody signUpReqDto reqDto) {
        userEntity userReg = new userEntity();
        userEntity user = userServiceImpl.getUser(reqDto.getEmail());

        if(user != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Email Already Exists!!");
        }

        userReg = mapper.map(reqDto, userEntity.class);
        userServiceImpl.registerUser(userReg);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully!!");
    }

    @GetMapping
    public ResponseEntity<String> entryMethod() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Spring Application Launched!!");
    }

}

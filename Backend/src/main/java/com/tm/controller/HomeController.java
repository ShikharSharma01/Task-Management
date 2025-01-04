package com.tm.controller;

import com.tm.dtos.SignUpReqDto;
import com.tm.dtos.SignUpRespDto;
import com.tm.entities.UserEntity;
import com.tm.entities.UserRole;
import com.tm.repository.UserRepository;
import com.tm.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpRespDto> userRegistration(@RequestBody SignUpReqDto reqDto) {
        UserEntity user = mapper.map(reqDto, UserEntity.class);
        user.setRole(UserRole.USER);
        SignUpRespDto response = new SignUpRespDto(userService.registerUser(user));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<String> entryMethod() {
        System.out.println("1 step - entry Method!!");
        return ResponseEntity.status(HttpStatus.CREATED).body("Spring Application Launched!!");
    }
}

package com.tutorial.spring.controller;

import com.tutorial.spring.constants.StringConstants;
import com.tutorial.spring.dto.user.UserDTO;
import com.tutorial.spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(successCreate(StringConstants.USER, savedUser), HttpStatus.OK);
    }
}

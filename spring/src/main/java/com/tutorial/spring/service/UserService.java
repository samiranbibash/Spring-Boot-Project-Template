package com.tutorial.spring.service;

import com.tutorial.spring.dto.user.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
}

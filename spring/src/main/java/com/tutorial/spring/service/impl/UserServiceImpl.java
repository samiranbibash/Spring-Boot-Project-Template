package com.tutorial.spring.service.impl;

import com.tutorial.spring.dto.user.UserDTO;
import com.tutorial.spring.entity.User;
import com.tutorial.spring.repo.UserRepository;
import com.tutorial.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .mobileNumber(userDTO.getMobileNumber())
                .roles(userDTO.getRoles())
                .build();
        return toDTO(userRepository.save(user));
    }
    private UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobileNumber(user.getMobileNumber())
                .roles(user.getRoles())
                .build();
    }
}

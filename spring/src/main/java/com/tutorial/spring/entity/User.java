package com.tutorial.spring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "unique_user_email", columnNames = "email"),
        @UniqueConstraint(name = "unique_user_mobile_number", columnNames = "mobile_number")})
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 250, name = "first_name", nullable = false)
    private String firstName;
    @Column(length = 250, name = "last_name", nullable = false)
    private String lastName;
    @Column(length = 250, name = "email", nullable = false)
    @Email
    private String email;
    private String mobileNumber;
    private String password;
    private String role;
}

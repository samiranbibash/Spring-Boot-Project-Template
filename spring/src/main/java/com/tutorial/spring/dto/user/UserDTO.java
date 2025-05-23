package com.tutorial.spring.dto.user;

import com.tutorial.spring.constants.FieldErrorConstant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotNull(message = FieldErrorConstant.NOT_NULL)
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String firstName;
    @NotNull(message = FieldErrorConstant.NOT_NULL)
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String lastName;
    @NotNull(message = FieldErrorConstant.NOT_NULL)
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    @Email(message = FieldErrorConstant.EMAIL)
    private String email;
    private String password;
    @Size(min = 10, max = 10, message = FieldErrorConstant.MOBILE_LENGTH)
    @NotNull(message = FieldErrorConstant.NOT_NULL)
    @NotBlank(message = FieldErrorConstant.NOT_BLANK)
    private String mobileNumber;
    private String roles;
}

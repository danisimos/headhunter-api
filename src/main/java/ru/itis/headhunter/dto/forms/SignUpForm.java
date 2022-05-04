package ru.itis.headhunter.dto.forms;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    @NotBlank(message = "account first name cannot be empty")
    private String firstName;
    @NotBlank(message = "account last name cannot be empty")
    private String lastName;
    @Email(message = "account email is invalid")
    private String email;
    @NotBlank(message = "account password cannot be empty")
    private String password;
}

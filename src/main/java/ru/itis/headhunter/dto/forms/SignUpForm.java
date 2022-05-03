package ru.itis.headhunter.dto.forms;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

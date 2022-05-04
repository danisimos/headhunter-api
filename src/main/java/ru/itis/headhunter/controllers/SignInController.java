package ru.itis.headhunter.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.headhunter.dto.forms.SignInForm;

@RestController
public class SignInController {
    @PostMapping("/api/signIn/")
    public ResponseEntity<String> signIn(@RequestBody SignInForm body) {
        return ResponseEntity.ok("Success");
    }
}

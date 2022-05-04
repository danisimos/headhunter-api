package ru.itis.headhunter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.headhunter.dto.CVDto;
import ru.itis.headhunter.dto.forms.CVForm;
import ru.itis.headhunter.services.CVService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CVController {
    private final CVService cvService;

    @PostMapping("/api/cv/")
    public ResponseEntity<CVDto> createCV(@RequestBody @Valid CVForm cvForm) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cvService.createCV(cvForm));
    }

    @GetMapping("/api/cv/")
    public ResponseEntity<List<CVDto>> getAllCV() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cvService.getAllCV());
    }
}

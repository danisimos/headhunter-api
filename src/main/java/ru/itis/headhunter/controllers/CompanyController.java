package ru.itis.headhunter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.headhunter.dto.CompanyDto;
import ru.itis.headhunter.dto.forms.CompanyForm;
import ru.itis.headhunter.services.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/api/companies/")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody @Valid CompanyForm companyForm) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.createCompany(companyForm));
    }

    @GetMapping("/api/companies/")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.getAllCompanies());
    }
}

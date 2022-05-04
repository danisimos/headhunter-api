package ru.itis.headhunter.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.headhunter.dto.AccountDto;
import ru.itis.headhunter.dto.VacancyDto;
import ru.itis.headhunter.dto.VacancyResponseDto;
import ru.itis.headhunter.dto.forms.VacancyForm;
import ru.itis.headhunter.models.VacancyResponse;
import ru.itis.headhunter.services.VacancyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping("/api/vacancies/")
    public ResponseEntity<VacancyDto> addVacancy(@RequestBody @Valid VacancyForm vacancyForm) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.addVacancy(vacancyForm));
    }

    @GetMapping("/api/vacancies/")
    public ResponseEntity<List<VacancyDto>> getAllVacancies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.getAllVacancies());
    }

    @GetMapping("/api/vacancies/getByCompany")
    public ResponseEntity<List<VacancyDto>> getAllVacanciesByCompanyId(@RequestParam(name = "companyId") Long companyId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.getAllByCompany(companyId));
    }

    @PostMapping("/api/vacancies/respond/")
    public ResponseEntity<VacancyResponseDto> respondToVacancy(@RequestParam(name = "vacancyId") Long vacancyId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.respondToVacancy(vacancyId));
    }

    @PostMapping("/api/vacancies/acceptResponse/")
    public ResponseEntity<AccountDto> acceptVacancyResponse(@RequestParam(name = "vacancyResponseId") Long vacancyResponseId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.acceptVacancyResponse(vacancyResponseId));
    }

    @PostMapping("/api/vacancies/addToFavorites/")
    public ResponseEntity<List<VacancyDto>> addVacancyToFavorites(@RequestParam(name = "vacancyId") Long vacancyId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vacancyService.addVacancyToFavorites(vacancyId));
    }
}

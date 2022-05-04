package ru.itis.headhunter.services;

import ru.itis.headhunter.dto.AccountDto;
import ru.itis.headhunter.dto.VacancyDto;
import ru.itis.headhunter.dto.VacancyResponseDto;
import ru.itis.headhunter.dto.forms.VacancyForm;

import java.util.List;

public interface VacancyService {
    VacancyDto addVacancy(VacancyForm vacancyForm);
    List<VacancyDto> getAllVacancies();
    List<VacancyDto> getAllByCompany(Long companyId);

    VacancyResponseDto respondToVacancy(Long vacancyId);

    AccountDto acceptVacancyResponse(Long vacancyResponseId);

    List<VacancyDto> addVacancyToFavorites(Long vacancyId);
}

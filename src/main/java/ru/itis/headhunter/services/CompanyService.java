package ru.itis.headhunter.services;

import ru.itis.headhunter.dto.CompanyDto;
import ru.itis.headhunter.dto.forms.CompanyForm;

import java.util.List;

public interface CompanyService {
    CompanyDto createCompany(CompanyForm companyForm);

    List<CompanyDto> getAllCompanies();
}

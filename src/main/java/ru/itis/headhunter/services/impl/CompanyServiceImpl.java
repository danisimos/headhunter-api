package ru.itis.headhunter.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.headhunter.dto.CompanyDto;
import ru.itis.headhunter.dto.forms.CompanyForm;
import ru.itis.headhunter.dto.mappers.CompanyMapper;
import ru.itis.headhunter.models.Account;
import ru.itis.headhunter.models.Company;
import ru.itis.headhunter.repositories.AccountsRepository;
import ru.itis.headhunter.repositories.CompanyRepository;
import ru.itis.headhunter.security.details.AccountUserDetails;
import ru.itis.headhunter.services.CompanyService;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final AccountsRepository accountsRepository;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyDto createCompany(CompanyForm companyForm) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        Company company = Company.builder()
                .description(companyForm.getDescription())
                .name(companyForm.getName())
                .accounts(Collections.singletonList(account))
                .build();

        CompanyDto companyDto = companyMapper.toCompanyDto(companyRepository.save(company));

        account.setCompany(company);
        account.setRole(Account.Role.EMPLOYER);
        accountsRepository.save(account);

        return companyDto;
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyMapper.toCompanyDtoList(companyRepository.findAll());
    }
}

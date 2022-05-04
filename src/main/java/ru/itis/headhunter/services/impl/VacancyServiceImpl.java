package ru.itis.headhunter.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.headhunter.dto.AccountDto;
import ru.itis.headhunter.dto.VacancyDto;
import ru.itis.headhunter.dto.VacancyResponseDto;
import ru.itis.headhunter.dto.forms.VacancyForm;
import ru.itis.headhunter.dto.mappers.AccountMapper;
import ru.itis.headhunter.dto.mappers.VacancyMapper;
import ru.itis.headhunter.dto.mappers.VacancyResponseMapper;
import ru.itis.headhunter.exceptions.NotCompanyAccountException;
import ru.itis.headhunter.exceptions.VacancyNotFoundException;
import ru.itis.headhunter.exceptions.VacancyResponseNotFoundException;
import ru.itis.headhunter.models.Account;
import ru.itis.headhunter.models.Vacancy;
import ru.itis.headhunter.models.VacancyResponse;
import ru.itis.headhunter.repositories.AccountsRepository;
import ru.itis.headhunter.repositories.VacancyRepository;
import ru.itis.headhunter.repositories.VacancyResponseRepository;
import ru.itis.headhunter.security.details.AccountUserDetails;
import ru.itis.headhunter.services.VacancyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final AccountsRepository accountsRepository;
    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;
    private final VacancyResponseMapper vacancyResponseMapper;
    private final VacancyResponseRepository vacancyResponseRepository;
    private final AccountMapper accountMapper;

    @Override
    public VacancyDto addVacancy(VacancyForm vacancyForm) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        if(!account.getRole().equals(Account.Role.EMPLOYER)) {
            throw new NotCompanyAccountException("this account without such company");
        }

        Vacancy vacancy = Vacancy.builder()
                .title(vacancyForm.getTitle())
                .company(account.getCompany())
                .description(vacancyForm.getDescription())
                .build();

        account.getCompany().getVacancies().add(vacancy);

        return vacancyMapper.toVacancyDto(vacancyRepository.save(vacancy));
    }

    @Override
    public List<VacancyDto> getAllVacancies() {
        return vacancyMapper.toVacancyDtoList(vacancyRepository.findAll());
    }

    @Override
    public List<VacancyDto> getAllByCompany(Long companyId) {
        return vacancyMapper.toVacancyDtoList(vacancyRepository.findAllByCompanyId(companyId));
    }

    @Override
    public VacancyResponseDto respondToVacancy(Long vacancyId) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        Vacancy vacancy = vacancyRepository.findById(vacancyId).orElseThrow(() -> new VacancyNotFoundException("no such vacancy"));

        VacancyResponse vacancyResponse = VacancyResponse.builder()
                .vacancy(vacancy)
                .account(account)
                .build();

        return vacancyResponseMapper.toVacancyResponseDto(vacancyResponseRepository.save(vacancyResponse));
    }

    @Override
    public AccountDto acceptVacancyResponse(Long vacancyResponseId) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        VacancyResponse vacancyResponse = vacancyResponseRepository.findById(vacancyResponseId)
                .orElseThrow(() -> new VacancyResponseNotFoundException("no such vacancy response"));

        if(!account.getRole().equals(Account.Role.EMPLOYER) ||
                !account.getCompany().getId().equals(vacancyResponse.getVacancy().getCompany().getId())) {
            throw new NotCompanyAccountException("this account without such company");
        }

        vacancyResponse.getAccount().setCompany(vacancyResponse.getVacancy().getCompany());
        vacancyResponse.getAccount().setRole(Account.Role.EMPLOYER);

        return accountMapper.toAccountDto(accountsRepository.save(vacancyResponse.getAccount()));
    }

    @Override
    public List<VacancyDto> addVacancyToFavorites(Long vacancyId) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        Vacancy vacancy = vacancyRepository.findById(vacancyId).orElseThrow(() -> new VacancyNotFoundException("no such vacancy"));

        account.getFavoritesVacancies().add(vacancy);
        accountsRepository.save(account);

        return vacancyMapper.toVacancyDtoList(account.getFavoritesVacancies().stream().toList());
    }
}

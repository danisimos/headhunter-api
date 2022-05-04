package ru.itis.headhunter.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.headhunter.dto.CVDto;
import ru.itis.headhunter.dto.forms.CVForm;
import ru.itis.headhunter.dto.mappers.CVMapper;
import ru.itis.headhunter.models.Account;
import ru.itis.headhunter.models.CV;
import ru.itis.headhunter.repositories.AccountsRepository;
import ru.itis.headhunter.repositories.CVRepository;
import ru.itis.headhunter.security.details.AccountUserDetails;
import ru.itis.headhunter.services.CVService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements CVService {
    private final AccountsRepository accountsRepository;
    private final CVRepository cvRepository;
    private final CVMapper cvMapper;

    @Override
    public CVDto createCV(CVForm cvForm) {
        Account account = ((AccountUserDetails) SecurityContextHolder.getContext().getAuthentication().getCredentials()).getAccount();

        CV cv = CV.builder()
                .account(account)
                .text(cvForm.getText())
                .title(cvForm.getTitle())
                .build();

        account.getCvList().add(cv);

        accountsRepository.save(account);

        return cvMapper.toCVDto(cvRepository.save(cv));
    }

    @Override
    public List<CVDto> getAllCV() {
        return cvMapper.toCVDtoList(cvRepository.findAll());
    }
}

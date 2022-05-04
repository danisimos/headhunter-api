package ru.itis.headhunter.services;

import ru.itis.headhunter.dto.CVDto;
import ru.itis.headhunter.dto.forms.CVForm;

import java.util.List;

public interface CVService {
    CVDto createCV(CVForm cvForm);

    List<CVDto> getAllCV();
}

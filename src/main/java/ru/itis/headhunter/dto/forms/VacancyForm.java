package ru.itis.headhunter.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.headhunter.models.Company;
import ru.itis.headhunter.models.VacancyResponse;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyForm {
    private String title;
    private String description;
}

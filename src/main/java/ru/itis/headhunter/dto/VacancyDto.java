package ru.itis.headhunter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.headhunter.models.Company;
import ru.itis.headhunter.models.VacancyResponse;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacancyDto {
    public enum State {
        ACTIVE, DELETED
    }

    private Long id;
    private String title;
    private String description;
}

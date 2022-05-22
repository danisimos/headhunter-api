package ru.itis.headhunter.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.headhunter.dto.VacancyDto;
import ru.itis.headhunter.models.Company;
import ru.itis.headhunter.models.VacancyResponse;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacancyForm {
    public enum Specialization {
        IT, SALES, MANAGEMENT, SCIENCE, MEDICINE
    }

    @NotBlank(message = "vacancy title cannot be empty")
    private String title;
    @NotBlank(message = "vacancy description cannot be empty")
    private String description;
    @NotNull
    @Min(value = 1)
    private Long salary;
    @NotNull
    private Specialization specialization;
}

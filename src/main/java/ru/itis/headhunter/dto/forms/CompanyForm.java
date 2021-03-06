package ru.itis.headhunter.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.headhunter.models.Account;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyForm {
    @NotBlank(message = "company name cannot be empty")
    private String name;
    @NotBlank(message = "company description cannot be empty")
    private String description;
}

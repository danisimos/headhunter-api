package ru.itis.headhunter.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.headhunter.models.Account;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CVForm {
    @NotBlank(message = "CV title cannot be empty")
    private String title;
    @NotBlank(message = "CV text cannot be empty")
    private String text;
}

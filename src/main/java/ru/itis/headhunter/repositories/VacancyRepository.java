package ru.itis.headhunter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.headhunter.models.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}

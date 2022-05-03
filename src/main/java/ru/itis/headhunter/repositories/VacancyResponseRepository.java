package ru.itis.headhunter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.headhunter.models.VacancyResponse;

public interface VacancyResponseRepository extends JpaRepository<VacancyResponse, Long> {
}

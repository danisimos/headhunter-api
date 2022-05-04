package ru.itis.headhunter.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.headhunter.models.Vacancy;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByCompanyId(Long companyId);
}

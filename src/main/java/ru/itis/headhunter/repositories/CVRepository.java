package ru.itis.headhunter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.headhunter.models.CV;

public interface CVRepository extends JpaRepository<CV, Long> {
}

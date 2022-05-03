package ru.itis.headhunter.dto.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.itis.headhunter.dto.CompanyDto;
import ru.itis.headhunter.dto.VacancyDto;
import ru.itis.headhunter.models.Company;
import ru.itis.headhunter.models.Vacancy;

import java.util.List;

@Mapper
public abstract class VacancyMapper {
    public abstract VacancyDto toVacancyDto(Vacancy vacancy);
    public abstract Vacancy toVacancy(VacancyDto vacancyDto);
    public abstract List<VacancyDto> toVacancyDtoList(List<Vacancy> vacancies);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateVacancyFromDto(VacancyDto vacancyDto, @MappingTarget Vacancy vacancy);
}

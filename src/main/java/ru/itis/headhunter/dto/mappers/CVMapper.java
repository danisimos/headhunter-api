package ru.itis.headhunter.dto.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.itis.headhunter.dto.CVDto;
import ru.itis.headhunter.dto.CompanyDto;
import ru.itis.headhunter.models.CV;
import ru.itis.headhunter.models.Company;

import java.util.List;

@Mapper
public abstract class CVMapper {
    public abstract CVDto toCVDto(CV cv);
    public abstract CV toCV(CVDto cvDto);
    public abstract List<CVDto> toCVDtoList(List<CV> cvList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateCVFromDto(CVDto cvDto, @MappingTarget CV cv);
}

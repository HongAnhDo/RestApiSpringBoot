package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.CompanyDTO;
import com.had.springbootdemo.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDTO getCompanyFromEntity(CompanyEntity companyEntity);
}
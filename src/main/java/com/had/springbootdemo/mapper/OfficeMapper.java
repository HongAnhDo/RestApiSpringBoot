package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.OfficeDTO;
import com.had.springbootdemo.entity.OfficeEntity;
import org.mapstruct.factory.Mappers;

public interface OfficeMapper {
    OfficeMapper INSTANCE = Mappers.getMapper(OfficeMapper.class);

    OfficeDTO toDto(OfficeEntity office);
}
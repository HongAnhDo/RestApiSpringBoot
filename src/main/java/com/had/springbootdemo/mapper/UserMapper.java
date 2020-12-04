package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.UserDTO;
import com.had.springbootdemo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO getUserFromEntity(UserEntity userEntity);
}
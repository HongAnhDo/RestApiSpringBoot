package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.PostDTO;
import com.had.springbootdemo.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "comments", ignore = true)
    PostDTO toPostDTO(PostEntity postEntity);
}

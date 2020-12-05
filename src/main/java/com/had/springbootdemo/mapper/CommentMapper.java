package com.had.springbootdemo.mapper;

import com.had.springbootdemo.dto.CommentDTO;
import com.had.springbootdemo.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "post.comments", ignore = true)
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-YYYY HH:mm:ss")
    @Mapping(target = "updatedAt", source = "updatedAt", dateFormat = "dd-MM-YYYY HH:mm:ss")
    CommentDTO toCommentDTO(CommentEntity commentEntity);
}
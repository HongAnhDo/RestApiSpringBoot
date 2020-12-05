package com.had.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String content;

    private List<CommentDTO> comments;

    private String createdAt;
    private String updatedAt;
}

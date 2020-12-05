package com.had.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO implements Serializable {
    private Long id;
    private String text;
    private PostDTO post;

    private String createdAt;
    private String updatedAt;
}

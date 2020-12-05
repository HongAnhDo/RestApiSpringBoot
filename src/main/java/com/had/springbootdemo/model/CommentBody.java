package com.had.springbootdemo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentBody implements Serializable {
    @NotNull(message = "Content comment must not be null")
    private String text;
}

package com.had.springbootdemo.controller;

import com.had.springbootdemo.dto.CommentDTO;
import com.had.springbootdemo.entity.CommentEntity;
import com.had.springbootdemo.entity.PostEntity;
import com.had.springbootdemo.exceptions.ResponseException;
import com.had.springbootdemo.mapper.CommentMapper;
import com.had.springbootdemo.model.CommentBody;
import com.had.springbootdemo.repository.CommentRepository;
import com.had.springbootdemo.repository.PostRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Api("API CRUD COMMENT")
@RestController
@RequestMapping
public class CommentController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private CommentMapper commentMapper = CommentMapper.INSTANCE;

    /**
     *
     * @param postId
     * @param commentBody
     * @return CommentDTO
     */
    @ApiOperation("Add comment in post")
    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDTO> addComment(@PathVariable(name = "postId") Long postId,
                                                 @Valid @RequestBody CommentBody commentBody){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setText(commentBody.getText());

        return postRepository.findById(postId).map(post-> {
            commentEntity.setPost(post);
            commentRepository.save(commentEntity);
            return ResponseEntity.ok(commentMapper.toCommentDTO(commentEntity));
        }).orElseThrow(() -> new ResponseException("Post id is not found"));
    }

    @GetMapping("/post/{postId}/comment")
    public ResponseEntity<Page<CommentDTO>> getAllCommentOfPost(@PathVariable(name = "postId") Long postId,
                                                                @RequestParam(defaultValue = "0") int pageNumber,
                                                                @RequestParam(defaultValue = "10") int size){
        Optional<PostEntity> postEntity = postRepository.findById(postId);
        if(!postEntity.isPresent()){
            throw new ResponseException("Post id is not found");
        }
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.Direction.DESC, "createdAt" );
        Page<CommentDTO> page =  commentRepository.findByPostId(postId, pageable)
                .map(comment -> commentMapper.toCommentDTO(comment));

        return ResponseEntity.ok(page);
    }
}

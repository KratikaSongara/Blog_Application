package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.CommentDTO;
import com.masai.model.Comments;
import com.masai.service.CommentsService;

@RestController
@RequestMapping("/api/posts")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> getCommentsByPostId(@PathVariable("postId") Integer postId) {
        return new ResponseEntity<>(commentsService.getCommentsByPostId(postId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentByIdAndPostId(@PathVariable("commentId") Integer commentId, @PathVariable("postId") Integer postId) {
        return new ResponseEntity<>(commentsService.getCommentByIdAndPostId(commentId,postId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDTO> createNewCommentForPost(@Valid @PathVariable("postId") Integer postId, @RequestBody Comments comment) {
        return new ResponseEntity<>(commentsService.createNewCommentForPost(postId,comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteByPostIdAndCommentId(@PathVariable("postId") Integer postId, @PathVariable("commentId") Integer commentId) {
        return new ResponseEntity<>(commentsService.deleteCommentByIdAndPostId(commentId,postId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateCommentByIdAndPostId(@Valid @PathVariable("commentId") Integer commentId, @PathVariable("postId") Integer postId, @RequestBody Comments comments) {
        return new ResponseEntity<>(commentsService.updateCommentByIdAndPostId(commentId,postId,comments),HttpStatus.ACCEPTED);
    }
}

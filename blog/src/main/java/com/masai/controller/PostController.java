package com.masai.controller;

import java.util.List;

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

import com.masai.model.Post;
import com.masai.model.PostDTO;
import com.masai.service.PostService;

@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("postId") int postId) {
        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createNewPost(post), HttpStatus.ACCEPTED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable("postId") int postId, @RequestBody Post post) {
        PostDTO post2 = postService.updatePostById(postId, post);
        if(post2 == null)
        {
            return new ResponseEntity<>("post not found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("post updated successfully", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable("postId") int postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("post deleted successfully", HttpStatus.ACCEPTED);
    }

}
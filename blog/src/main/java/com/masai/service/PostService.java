package com.masai.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.masai.model.Post;
import com.masai.model.PostDTO;

public interface PostService {
    public List<PostDTO> getAllPosts();
    public PostDTO getPostById(int postId);
    public PostDTO createNewPost(Post post);
    public PostDTO updatePostById(int postId, PostDTO postdto);
    public String deletePostById(int postId);
    public Page<Post> pagination(int pageno, int pagesize);
    public List<Post> sorting(String option);
    public Page<Post> paginationAndSorting(int pageno, int pagesize, String option);
}

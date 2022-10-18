package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Post;
import com.masai.model.PostDTO;
import com.masai.repository.PostDao;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDao postDao;

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> list = postDao.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for(int i=0; i<list.size(); i++)
        {
            postDTOList.add(new PostDTO());
            postDTOList.get(i).setContent(list.get(i).getContent());
            postDTOList.get(i).setTitle(list.get(i).getTitle());
        }
        return postDTOList;
    }

    @Override
    public PostDTO getPostById(int postId) {
        Optional<Post> opt = postDao.findById(postId);
        PostDTO post = new PostDTO(opt.get().getContent(),opt.get().getTitle());
        return post;
    }

    @Override
    public PostDTO createNewPost(Post post) {
        postDao.save(post);
        PostDTO post2 = new PostDTO(post.getContent(),post.getTitle());
        return post2;
    }

    @Override
    public PostDTO updatePostById(int postId, Post post) {
        Optional<Post> opt = postDao.findById(postId);
        if(opt.get() != null)
        {
            postDao.save(post);
            PostDTO post2 = new PostDTO(post.getContent(),post.getTitle());
            return post2;
        }
        return null;
    }

    @Override
    public String deletePostById(int postId) {
        postDao.deleteById(postId);
        return "post successfully deleted";
    }
}
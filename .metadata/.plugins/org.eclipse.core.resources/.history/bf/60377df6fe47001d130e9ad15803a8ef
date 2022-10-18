package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CommentDTO;
import com.masai.model.Comments;
import com.masai.model.Post;
import com.masai.repository.CommentsDao;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    private CommentsDao commentsDao;

    private Post post = new Post();

    @Override
    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        List<Comments> list = commentsDao.findByPostId(postId);
        List<CommentDTO> comment = new ArrayList<>();
        for(int i=0; i<list.size(); i++)
        {
        	comment.add(new CommentDTO());
        	comment.get(i).setComment(list.get(i).getComment());
        	comment.get(i).setUsername(list.get(i).getUsername());
        }
        return comment;
    }

    @Override
    public CommentDTO getCommentByIdAndPostId(Integer commentId, Integer postId) {
        Comments opt = commentsDao.findByCommentIdAndPostId(commentId,postId);
        return new CommentDTO(opt.getComment(),opt.getUsername());
    }

    @Override
    public CommentDTO createNewCommentForPost(Integer postId, Comments comment) {
        post.getList().add(comment);
        commentsDao.save(comment);
        return new CommentDTO(comment.getComment(),comment.getUsername());
    }

    @Override
    public CommentDTO updateCommentByIdAndPostId(Integer commentId, Integer postId, Comments comments) {
        Comments comment = commentsDao.findByCommentIdAndPostId(commentId,postId);
        if(comment != null)
        {
            commentsDao.save(comments);
            return new CommentDTO(comment.getComment(),comment.getUsername());
        }
        return null;
    }

    @Override
    public String deleteCommentByIdAndPostId(Integer commentId, Integer postId) {
        Comments comments = commentsDao.findByCommentIdAndPostId(commentId,postId);
        commentsDao.deleteById(comments.getCommentId());
        return "comment deleted successfully";
    }

}

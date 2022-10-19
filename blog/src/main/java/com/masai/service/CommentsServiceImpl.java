package com.masai.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CommentNotFoundException;
import com.masai.exception.PostNotFoundException;
import com.masai.model.CommentDTO;
import com.masai.model.Comments;
import com.masai.model.Post;
import com.masai.repository.CommentsDao;
import com.masai.repository.PostDao;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private PostDao postDao;

    @Override
    public List<CommentDTO> getCommentsByPostId(Integer postId) {
        List<Comments> list = commentsDao.findBypostId(postId);
        if(list.size()==0) throw new CommentNotFoundException("no comments found");
        List<CommentDTO> comment = new ArrayList<>();
        for(int i=0; i<list.size(); i++)
        {
        	comment.add(new CommentDTO());
        	comment.get(i).setComment(list.get(i).getComment());
        	comment.get(i).setUsername(list.get(i).getUsername());
        }
        return comment;
//    	return null;
    }

    @Override
    public CommentDTO getCommentByIdAndPostId(Integer commentId, Integer postId) {
        Comments opt = commentsDao.findByCommentIdAndPostId(commentId,postId);
        if(opt == null) throw new CommentNotFoundException("no comment with this id found on this post");
        return new CommentDTO(opt.getComment(),opt.getUsername());
//    	return null;
    }

    @Override
    public CommentDTO createNewCommentForPost(Integer postId, Comments comment) {
    	Optional<Post> opt = postDao.findById(postId);
    	if(opt.get()==null) throw new PostNotFoundException("post with thid id not found");
    	Post post = opt.get();
    	post.getList().add(comment);
    	comment.setPost(post);
        commentsDao.save(comment);
        return new CommentDTO(comment.getComment(),comment.getUsername());
    }

    @Override
    public CommentDTO updateCommentByIdAndPostId(Integer commentId, Integer postId, Comments comments) {
        Comments comment = commentsDao.findByCommentIdAndPostId(commentId,postId);
        if(comment != null)
        {
        	comments.setCommentId(commentId);
        	Optional<Post> opt = postDao.findById(postId);
        	Post post = opt.get();
//        	post.getList().add(comments); when we are updating a comment so since we know that there is one separate
        	//linking table created which contains the primary key of both the tables and post entity will take the help
        	//of this table to navigate. So, if we try to save the new comment in post also so it will give error becoz
        	//it will try to save the same id of comment again and since this is the primary key of the linking table
        	//and we know that primary key cannot be repeated, so it will give error
        	//we know that the id will remain same so we need to save the same id again in the linking table
        	//we just need to update the comment in the comment table
        	comments.setPost(post);
            commentsDao.save(comments);
            return new CommentDTO(comments.getComment(),comments.getUsername());
        }
        throw new CommentNotFoundException("no comment with this id found on this post");
    }

    @Override
    public String deleteCommentByIdAndPostId(Integer commentId, Integer postId) {
        Comments comments = commentsDao.findByCommentIdAndPostId(commentId,postId);
        if(comments == null) throw new CommentNotFoundException("no comment with this id found on this post");
        commentsDao.deleteById(comments.getCommentId());
        return "comment deleted successfully";
    }

}

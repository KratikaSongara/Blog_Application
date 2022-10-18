package com.masai.service;

import java.util.List;

import com.masai.model.CommentDTO;
import com.masai.model.Comments;

public interface CommentsService {
    public List<CommentDTO> getCommentsByPostId(Integer postId);
    public CommentDTO getCommentByIdAndPostId(Integer commentId, Integer postId);
    public CommentDTO createNewCommentForPost(Integer postId, Comments comment);
    public CommentDTO updateCommentByIdAndPostId(Integer commentId, Integer postId, Comments comments);
    public String deleteCommentByIdAndPostId(Integer commentId, Integer postId);
}

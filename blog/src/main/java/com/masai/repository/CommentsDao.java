package com.masai.repository;

import com.masai.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao extends JpaRepository<Comments, Integer> {
    public List<Comments> findByPostId(Integer postId);
    public Comments findByCommentIdAndPostId(Integer commentId, Integer postId);
}

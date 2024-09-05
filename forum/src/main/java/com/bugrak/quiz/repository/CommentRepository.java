package com.bugrak.quiz.repository;

import com.bugrak.quiz.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> userIdAndPostId(Integer userId, Integer postId);

    List<Comment> findByUserId(Integer userId);

    List<Comment> findByPostId(Integer postId);
}

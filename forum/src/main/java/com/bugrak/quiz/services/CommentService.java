package com.bugrak.quiz.services;

import com.bugrak.quiz.entities.Comment;
import com.bugrak.quiz.entities.Post;
import com.bugrak.quiz.entities.User;
import com.bugrak.quiz.repository.CommentRepository;
import com.bugrak.quiz.requests.CommentRequest;
import com.bugrak.quiz.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<CommentResponse> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId) {
        List<Comment> list;
        if (userId.isPresent() && postId.isPresent()) {
            list =  commentRepository.userIdAndPostId(userId.get(),postId.get());
        } else if (userId.isPresent()) {
            list =  commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            list = commentRepository.findByPostId(postId.get());
        }
        else
            list =  commentRepository.findAll();
            return list.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }

    public Comment getOneCommentById(int commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentRequest comment) {
        User user = userService.findByUserId(comment.getUserId());
        Post post = postService.getOnePost(comment.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(comment.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(comment.getText());
            return commentRepository.save(commentToSave);
        }
        else
            return null;
    }
}

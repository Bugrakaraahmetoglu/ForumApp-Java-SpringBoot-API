package com.bugrak.quiz.controller;

import com.bugrak.quiz.entities.Comment;
import com.bugrak.quiz.requests.CommentRequest;
import com.bugrak.quiz.response.CommentResponse;
import com.bugrak.quiz.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponse> getComments(@RequestParam Optional<Integer> userId, @RequestParam Optional<Integer> postId ) {
        return commentService.getAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable int commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment addComment(@RequestBody CommentRequest comment) {
        return commentService.createComment(comment);
    }
}

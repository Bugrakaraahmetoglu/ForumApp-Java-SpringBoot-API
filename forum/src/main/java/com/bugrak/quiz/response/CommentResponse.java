package com.bugrak.quiz.response;

import com.bugrak.quiz.entities.Comment;
import lombok.Data;

@Data
public class CommentResponse {

    int id;
    int userId;
    int postId;
    String userName;
    String text;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.postId = comment.getPost().getId();
        this.userName = comment.getUser().getUserName();
        this.text = comment.getText();
    }
}

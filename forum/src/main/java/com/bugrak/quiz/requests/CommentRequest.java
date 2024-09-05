package com.bugrak.quiz.requests;

import lombok.Data;

@Data
public class CommentRequest {

    Integer id;
    Integer userId;
    Integer postId;
    String text;
}

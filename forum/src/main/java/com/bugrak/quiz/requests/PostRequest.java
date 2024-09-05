package com.bugrak.quiz.requests;

import lombok.Data;

@Data
public class PostRequest {

    int id;
    String text;
    String title;
    int userId;
}

package com.bugrak.quiz.response;

import com.bugrak.quiz.entities.Post;
import lombok.Data;

@Data
public class PostResponse {
    int id;
    int userId;
    String userName;
    String title;
    String text;

    public PostResponse(Post entity){
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}

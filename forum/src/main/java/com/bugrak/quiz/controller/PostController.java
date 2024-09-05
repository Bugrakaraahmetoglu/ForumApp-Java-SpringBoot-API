package com.bugrak.quiz.controller;

import com.bugrak.quiz.entities.Post;
import com.bugrak.quiz.requests.PostRequest;
import com.bugrak.quiz.response.PostResponse;
import com.bugrak.quiz.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Integer> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Integer postId) {
        return postService.getOnePost(postId);
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody PostRequest newPostRequest) {
        return postService.addPost(newPostRequest);
    }
}

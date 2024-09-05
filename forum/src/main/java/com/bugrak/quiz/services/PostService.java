package com.bugrak.quiz.services;

import com.bugrak.quiz.entities.Post;
import com.bugrak.quiz.entities.User;
import com.bugrak.quiz.repository.PostRepository;
import com.bugrak.quiz.requests.PostRequest;
import com.bugrak.quiz.response.PostResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Transactional
    public List<PostResponse> getAllPosts(Optional<Integer> userId) {
        List<Post> list;
        if (userId.isPresent()) {
             list = postRepository.findByUserId(userId.get());
        }
        list = postRepository.findAll();
        return list.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());

    }

    public Post getOnePost(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post addPost(PostRequest newPostRequest) {
        User user =  userService.findByUserId(newPostRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);

        return postRepository.save(toSave);
    }
}

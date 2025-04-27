package com.example.custom_validations.controller;

import com.example.custom_validations.dto.Post;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @PostMapping
    public String createPost(@RequestBody @Valid Post post) {
        return "Post created successfully";
    }

}

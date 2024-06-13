package com.example.foro_hub_alura.controller;

import com.example.foro_hub_alura.dto.PostDTO;
import com.example.foro_hub_alura.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public List<PostDTO> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public List<PostDTO> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }
}

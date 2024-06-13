package com.example.foro_hub_alura.service;

import com.example.foro_hub_alura.dto.PostDTO;
import com.example.foro_hub_alura.model.Post;
import com.example.foro_hub_alura.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<PostDTO> getAllPost(){
        return postRepository.findAll().stream()
                .map(p -> new PostDTO(p.getId(), p.getNombre()))
                .collect(Collectors.toList());
    }

    public List<PostDTO> getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            return post.stream()
                    .map(p -> new PostDTO(p.getId(), p.getNombre()))
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }
}

package com.example.demo.service;

import com.example.demo.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public List<Author> findAll();
    public Optional<Author> findById(Long id);



}

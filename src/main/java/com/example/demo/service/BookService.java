package com.example.demo.service;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> findAll();

    public Optional<Book> findById(Long id);

    public Optional<Book> add(BookDto bookDto);

    public Optional<Book> edit(Long id,BookDto bookDto);

    public void delete(Long id);

    public void getCopy(Long id);

    public void addCopy(Long id);

}

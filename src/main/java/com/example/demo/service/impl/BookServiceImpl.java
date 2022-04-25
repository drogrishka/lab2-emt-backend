package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.exceptions.AuthorNotFoundException;
import com.example.demo.model.exceptions.BookNotFoundException;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> add(BookDto bookDto) {
        Author author=this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),author, bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author author=this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(AuthorNotFoundException::new);
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void delete(Long id) {
        Book book=findById(id).orElseThrow(BookNotFoundException::new);
        this.bookRepository.delete(book);
    }

    @Override
    public void getCopy(Long id) {
        Book book=findById(id).orElseThrow(BookNotFoundException::new);
        book.getCopy();

        this.bookRepository.save(book);
    }

    @Override
    public void addCopy(Long id) {
        Book book=findById(id).orElseThrow(BookNotFoundException::new);
        book.addCopy();

        this.bookRepository.save(book);
    }
}

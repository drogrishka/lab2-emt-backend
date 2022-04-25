package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    public Book(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    Author author;

    Integer availableCopies;

    public void getCopy(){
        this.availableCopies--;
    }
    public void addCopy(){
        this.availableCopies++;
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

}

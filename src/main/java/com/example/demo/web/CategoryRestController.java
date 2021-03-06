package com.example.demo.web;

import com.example.demo.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "https://library-app-frontend-emt-191024.herokuapp.com/")
@RequestMapping("/api/categories")
public class CategoryRestController {

    @GetMapping
    public List<Category> findAll(){
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}

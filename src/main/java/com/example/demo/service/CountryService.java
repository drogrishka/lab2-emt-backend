package com.example.demo.service;

import com.example.demo.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();
    public Optional<Country> findById(Long id);
}

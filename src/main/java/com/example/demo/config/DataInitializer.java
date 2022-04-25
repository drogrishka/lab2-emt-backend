package com.example.demo.config;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.model.Country;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initData() {
        //Countries
        Country macedonia=new Country("Macedonia","Europe");
        Country usa=new Country("United States of America","North America");
        Country france=new Country("France","Europe");
        Country australia=new Country("Australia", "Australia");
        Country egypt=new Country("Egypt","Africa");
        Country japan=new Country("Japan","Asia");
        Country england=new Country("England","Europe");
        Country russia=new Country("Russia","Europe");
        countryRepository.save(macedonia);
        countryRepository.save(usa);
        countryRepository.save(france);
        countryRepository.save(australia);
        countryRepository.save(egypt);
        countryRepository.save(japan);
        countryRepository.save(england);
        countryRepository.save(russia);

        //Authors
        Author slavkoJanevski=new Author("Slavko","Janevski",macedonia);
        Author kostaPetrov=new Author("Kosta", "Petrov",macedonia);
        Author markTwain=new Author("Mark","Twain",usa);
        Author victorHugo=new Author("Victor","Hugo",france);
        Author yusufIdriz=new Author("Yusuf","Idriz",egypt);
        Author vasilIljoski=new Author("Vasil","Iljoski",macedonia);
        Author williamShakespeare=new Author("William","Shakespeare",england);
        Author fyodorDostoevsky=new Author("Fyodor","Dostoevsky",russia);
        authorRepository.save(slavkoJanevski);
        authorRepository.save(kostaPetrov);
        authorRepository.save(markTwain);
        authorRepository.save(victorHugo);
        authorRepository.save(yusufIdriz);
        authorRepository.save(vasilIljoski);
        authorRepository.save(williamShakespeare);
        authorRepository.save(fyodorDostoevsky);

        //Books
        Book ulica=new Book("Ulica", Category.NOVEL,slavkoJanevski,15);
        Book stravot=new Book("Stravot",Category.BIOGRAPHY,kostaPetrov,20);
        Book lifeOnTheMississippi=new Book("Life on the Mississippi",Category.NOVEL,markTwain,5);
        Book lesMiserables=new Book("Les Miserables",Category.DRAMA,victorHugo,40);
        Book houseOfFlesh=new Book("House of Flesh", Category.FANTASY,yusufIdriz,3);
        Book crimeandPunishment=new Book("Crime and punishment",Category.THRILER,fyodorDostoevsky,7);
        Book begalka=new Book("Begalka",Category.DRAMA, vasilIljoski, 12);
        Book romeoAndJuliet=new Book("Romeo and Juliet",Category.CLASSICS,williamShakespeare,16);
        bookRepository.save(ulica);
        bookRepository.save(stravot);
        bookRepository.save(lifeOnTheMississippi);
        bookRepository.save(lesMiserables);
        bookRepository.save(houseOfFlesh);
        bookRepository.save(crimeandPunishment);
        bookRepository.save(begalka);
        bookRepository.save(romeoAndJuliet);
    }
}

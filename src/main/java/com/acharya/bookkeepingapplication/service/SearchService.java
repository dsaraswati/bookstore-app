package com.acharya.bookkeepingapplication.service;

import com.acharya.bookkeepingapplication.models.Book;
import com.acharya.bookkeepingapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchByTitle(String title) {
        return bookRepository.searchByTitle(title)
                .stream()
                .map(Book::new)
                .toList();
    }

    public List<Book> searchByGenre(String genre) {
        return bookRepository.searchByGenre(genre)
                .stream()
                .map(Book::new)
                .toList();
    }

    public List<Book> searchByAuthor(String authorName) {
        return bookRepository.searchByAuthor(authorName)
                .stream()
                .map(Book::new)
                .toList();
    }
}

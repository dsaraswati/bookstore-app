package com.acharya.bookkeepingapplication.controller;

import com.acharya.bookkeepingapplication.models.Book;
import com.acharya.bookkeepingapplication.service.SearchService;
import com.acharya.bookkeepingapplication.models.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/search")
public class SearchPagesController {

    @Autowired
    private SearchService service;

    @GetMapping("/byTitle")
    public String renderSearchByTitle(Model model) {
        model.addAttribute("searchRequest", new SearchRequest());
        return "pages/search-by-title";
    }

    @GetMapping("/byAuthor")
    public String renderSearchByAuthor(Model model) {
        model.addAttribute("searchRequest", new SearchRequest());
        return "pages/search-by-author";
    }

    @GetMapping("/byGenre")
    public String renderSearchByGenre(Model model) {
        model.addAttribute("searchRequest", new SearchRequest());
        return "pages/search-by-genre";
    }

    @PostMapping
    public String search(@ModelAttribute SearchRequest searchRequest, Model model) {
        switch (searchRequest.getSearchByType()) {
            case TITLE -> {
                model.addAttribute("searchString", "title ~ " + searchRequest.getSearchString());
                List<Book> books = service.searchByTitle(searchRequest.getSearchString());
                model.addAttribute("books", books);
                return "pages/search-by-title";
            }
            case AUTHOR -> {
                model.addAttribute("searchString", "author ~ " + searchRequest.getSearchString());
                List<Book> books = service.searchByAuthor(searchRequest.getSearchString());
                model.addAttribute("books", books);
                return "pages/search-by-author";
            }
            case GENRE -> {
                model.addAttribute("searchString", "genre ~ " + searchRequest.getSearchString());
                List<Book> books = service.searchByGenre(searchRequest.getSearchString());
                model.addAttribute("books", books);
                return "pages/search-by-genre";
            }
        }
        return "pages/error";
    }
}

package com.acharya.bookkeepingapplication.controller;

import com.acharya.bookkeepingapplication.entity.Book;
import com.acharya.bookkeepingapplication.entity.Inventory;
import com.acharya.bookkeepingapplication.entity.OrderHistory;
import com.acharya.bookkeepingapplication.entity.Student;
import com.acharya.bookkeepingapplication.models.CheckoutRequest;
import com.acharya.bookkeepingapplication.repository.BookRepository;
import com.acharya.bookkeepingapplication.repository.InventoryRepository;
import com.acharya.bookkeepingapplication.repository.OrderHistoryRepository;
import com.acharya.bookkeepingapplication.repository.StudentRepository;
import com.acharya.bookkeepingapplication.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/checkout")
public class CheckoutController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping
    @RequestMapping("/{bookId}")
    public String checkoutBook(@PathVariable("bookId") Integer bookId, Model model) {

        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Inventory> inventory = inventoryRepository.findByBookId(bookId);

        if (book.isPresent() && inventory.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("inventory", inventory.get());
            model.addAttribute("checkoutRequest", new CheckoutRequest());
            return "pages/checkout";
        }
        return "pages/error";
    }

    @PostMapping
    public String checkoutBook(@ModelAttribute CheckoutRequest checkoutRequest, Model model) {

        boolean checkoutSuccessful = checkoutService.checkoutBook(checkoutRequest.getBookId(), checkoutRequest.getStudentId());

        if (checkoutSuccessful) {
            return "index";
        }

        return "pages/error";
    }


}

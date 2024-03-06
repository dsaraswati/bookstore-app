package com.acharya.bookkeepingapplication.service;

import com.acharya.bookkeepingapplication.entity.Book;
import com.acharya.bookkeepingapplication.entity.Inventory;
import com.acharya.bookkeepingapplication.entity.OrderHistory;
import com.acharya.bookkeepingapplication.entity.Student;
import com.acharya.bookkeepingapplication.models.CheckoutRequest;
import com.acharya.bookkeepingapplication.repository.BookRepository;
import com.acharya.bookkeepingapplication.repository.InventoryRepository;
import com.acharya.bookkeepingapplication.repository.OrderHistoryRepository;
import com.acharya.bookkeepingapplication.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;


    @Transactional
    public boolean checkoutBook(Integer bookId, String studentId) {
        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Inventory> inventory = inventoryRepository.findByBookId(bookId);
        Optional<Student> student = studentRepository.findById(studentId);

        if (book.isPresent() &&
                inventory.isPresent() &&
                student.isPresent() &&
                inventory.get().getStock() > 0) {

            inventory.get().setStock(inventory.get().getStock() - 1);
            OrderHistory orderHistory = new OrderHistory(book.get(), student.get());
            orderHistoryRepository.save(orderHistory);
            return true;
        }
        return false;
    }
}

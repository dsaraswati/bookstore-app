package com.acharya.bookkeepingapplication.service;

import com.acharya.bookkeepingapplication.entity.Admin;
import com.acharya.bookkeepingapplication.entity.Inventory;
import com.acharya.bookkeepingapplication.entity.OrderHistory;
import com.acharya.bookkeepingapplication.entity.Student;
import com.acharya.bookkeepingapplication.models.StudentRequest;
import com.acharya.bookkeepingapplication.models.UpdateInventoryRequest;
import com.acharya.bookkeepingapplication.repository.AdminRepository;
import com.acharya.bookkeepingapplication.repository.InventoryRepository;
import com.acharya.bookkeepingapplication.repository.OrderHistoryRepository;
import com.acharya.bookkeepingapplication.repository.StudentRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public String login(String username, String password) throws SecurityException, NoSuchAlgorithmException {

        String hashedPassword = hashPassword(password);
        Optional<Admin> admin = adminRepository.findById(username);

        if (admin.isEmpty() || !hashedPassword.equals(admin.get().getPassword())) {
            throw new SecurityException("Invalid login, username or password doesn't match our records");
        }

        String token  = UUID.randomUUID().toString();
        admin.get().setToken(token);
        adminRepository.save(admin.get());
        return token;
    }

    public void addStudent(StudentRequest studentRequest) {
        Student student = new Student(
                studentRequest.getId(),
                studentRequest.getName(),
                studentRequest.getCourse(),
                studentRequest.getBranch(),
                studentRequest.getAaid());
        studentRepository.save(student);
    }

    public void updateInventory(UpdateInventoryRequest updateInventoryRequest) {
        Inventory inventory = new Inventory(
                updateInventoryRequest.getBookId(),
                updateInventoryRequest.getStock());
        inventoryRepository.save(inventory);
    }

    public List<OrderHistory> getOrderHistory() {
        return orderHistoryRepository.findAll();
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedPasswordBytes = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hashedPassword = new StringBuilder();
        for (byte b : encodedPasswordBytes) {
            hashedPassword.append(String.format("%02x", b));
        }
        return hashedPassword.toString();
    }

    public boolean validateToken(String token) {
        Optional<Admin> optAdmin = adminRepository.findByToken(token);
        return optAdmin.isPresent();
    }

    public void logout(String token) {
        Optional<Admin> admin = adminRepository.findByToken(token);
        if (admin.isEmpty()) {
            return;
        }
        admin.get().setToken("");
        adminRepository.save(admin.get());
        return;
    }
}

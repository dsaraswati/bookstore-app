package com.acharya.bookkeepingapplication.controller;

import com.acharya.bookkeepingapplication.entity.OrderHistory;
import com.acharya.bookkeepingapplication.models.LoginRequest;
import com.acharya.bookkeepingapplication.models.StudentRequest;
import com.acharya.bookkeepingapplication.models.UpdateInventoryRequest;
import com.acharya.bookkeepingapplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/login")
    public String renderLogin(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "pages/login";
    }

    @PostMapping(path = "/login")
    public String loginAdmin(@ModelAttribute LoginRequest loginRequest, Model model) {
        model.addAttribute("loginRequest", new LoginRequest());

        try {
            String token = adminService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return renderAdmin(model, token);
        } catch(Exception e) {
            model.addAttribute("error", "Invalid login, username or password doesn't match our records");
            return "pages/login";
        }
    }

    @GetMapping("/logout")
    public String logout(@RequestParam("token") String token) {
        adminService.logout(token);
        return "index";
    }

    @PostMapping(path = "add-student")
    public String addStudent(@ModelAttribute StudentRequest studentRequest, Model model) {
        if (!adminService.validateToken(studentRequest.getToken())) {
            return "pages/error";
        }
        adminService.addStudent(studentRequest);
        return renderAdmin(model, studentRequest.getToken());
    }

    @PostMapping(path = "update-inventory")
    public String updateInventory(@ModelAttribute UpdateInventoryRequest updateInventoryRequest, Model model) {
        if (!adminService.validateToken(updateInventoryRequest.getToken())) {
            return "pages/error";
        }
        adminService.updateInventory(updateInventoryRequest);
        return renderAdmin(model, updateInventoryRequest.getToken());
    }

    private String renderAdmin(Model model, String token) {
        List<OrderHistory> hist = adminService.getOrderHistory();
        model.addAttribute("token", token);
        model.addAttribute("studentRequest", new StudentRequest());
        model.addAttribute("updateInventoryRequest", new UpdateInventoryRequest());
        model.addAttribute("orderHistory", hist);
        return "pages/admin";
    }

}

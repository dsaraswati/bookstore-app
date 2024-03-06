package com.acharya.bookkeepingapplication.repository;

import com.acharya.bookkeepingapplication.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByToken(String token);
}

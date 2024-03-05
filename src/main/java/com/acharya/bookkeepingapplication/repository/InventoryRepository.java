package com.acharya.bookkeepingapplication.repository;

import com.acharya.bookkeepingapplication.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByBookId(Integer bookId);

}

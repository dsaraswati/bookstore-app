package com.acharya.bookkeepingapplication.repository;

import com.acharya.bookkeepingapplication.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {
}

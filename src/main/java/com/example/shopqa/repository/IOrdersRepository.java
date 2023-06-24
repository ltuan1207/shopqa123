package com.example.shopqa.repository;

import com.example.shopqa.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders, Long> {
}


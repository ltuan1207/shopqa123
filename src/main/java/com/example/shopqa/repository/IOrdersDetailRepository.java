package com.example.shopqa.repository;

import com.example.shopqa.entity.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Long> {
}


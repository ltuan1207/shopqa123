package com.example.shopqa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_details")
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name = "quantity")
//    @NotBlank(message = "Quantity is required !")
//    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @Column(name = "unit_price")
    private Long Price;
}

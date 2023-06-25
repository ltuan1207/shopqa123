package com.example.shopqa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "order_details")
@Getter
@Setter
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;

    @Column(name = "quantity")
//    @NotBlank(message = "Quantity is required !")
//    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @Column(name = "unit_price")
    private Long Price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
}
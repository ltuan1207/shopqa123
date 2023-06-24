package com.example.shopqa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_details")
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "quantity")
    @NotBlank(message = "Quantity is required !")
    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

//    @ManyToOne
//    @JoinColumn(name="order_id")
//    private Order order;
}
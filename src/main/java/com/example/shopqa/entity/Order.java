package com.example.shopqa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "email")
    @NotBlank(message = "Email is required!")
    @Size(min = 6, message = "Email must be at least 6 characters!")
    @Email(message = "Invalid email format!")
    private String email;

    @Column(name = "order_date")
    @NotNull(message = "Order date is required!")
    private Timestamp orderDate;

    @Column(name = "delivery_date")
    private Timestamp deliveryDate;

    @Column(name = "delivery_status")
    @NotBlank(message = "Delivery status is required!")
    private String deliveryStatus;

    @Column(name = "paid")
    @NotNull(message = "Paid status is required!")
    private boolean paid;

    @Column(name = "total_amount")
    @NotNull(message = "Total amount is required!")
    @DecimalMin(value = "0.01", message = "Total amount must be greater than 0!")
    private BigDecimal totalAmount;

//    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
//    @JoinColumn
//    private List<OrderDetail> orderDetail;

}
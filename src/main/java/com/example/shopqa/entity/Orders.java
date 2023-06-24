package com.example.shopqa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

//    @Column(name = "email")
//    @NotBlank(message = "Email is required!")
//    @Size(min = 6, message = "Email must be at least 6 characters!")
//    @Email(message = "Invalid email format!")
//    private String email;

    @Column(name = "order_date")
    @NotNull(message = "Order date is required!")
    private Date orderDate;

//    @Column(name = "delivery_date")
//    private Date deliveryDate;

//    @Column(name = "delivery_status")
//    @NotBlank(message = "Delivery status is required!")
//    private String deliveryStatus;

    @Column(name = "paid")
    @NotNull(message = "Paid status is required!")
    private boolean paid;

    @Column(name = "total_amount")
//    @NotNull(message = "Total amount is required!")
//    @DecimalMin(value = "0.01", message = "Total amount must be greater than 0!")
    private Long totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersDetail> orderDetails;

}

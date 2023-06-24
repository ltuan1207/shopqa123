package com.example.shopqa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Data
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private long price;

    // getters and setters
    @ManyToOne
    @JoinColumn(name="category_id")
    private ProductCategory category;

}
//
//    @OneToMany
//    @JoinColumn(name="order_details")
//    private OrderDetail orderdetail;
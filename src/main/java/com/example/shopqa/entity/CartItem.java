package com.example.shopqa.entity;

import lombok.Data;

@Data
public class CartItem {
    private Integer id;
    private String imageUrl;
    private String name;
    private long price;

    private int quantity;
}

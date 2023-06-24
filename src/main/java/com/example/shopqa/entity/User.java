package com.example.shopqa.entity;

/*import do_an.do_an_java.Validator.annotation.ValidUsername;*/
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required!")
    @Size(max = 50, message = "Username must be less then 50 characters!")
/*    @ValidUsername*/
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required!")
    private String password;

    @Column(name = "email", length = 50, nullable = false)
    @Size(max = 50, message = "Email must be less than 50 characters!")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Your name is required!")
    @Size(max = 50, message = "Your name must be less then 50 characters!")
    private String name;

    @Size(max = 150)
    @Column(name = "address", length = 150)
    private String address;

    @Size(max = 5)
    @Column(name = "sex", length = 5)
    private String sex;

    @Lob
    @Column(name = "image")
    private String image;
    @Size(max = 10)
    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "birthday")
    private LocalDate birthday;
//
//    @ManyToMany
//    @JoinColumn
//    private OrderDetail orderDetail;
/*
    @ManyToMany
    @JoinTable(name = "user-role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();*/
}

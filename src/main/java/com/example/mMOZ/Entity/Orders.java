package com.example.mMOZ.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "orders")
public class Orders {


    @Id
    private Long order_number;
    @NotBlank(message = "Imię nie może być puste")
    @Size(max = 80,message = "Imię nie może mieć powyżej 80 znaków")
    private String firstname;
    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(max = 80,message = "Nazwisko nie może mieć powyżej 80 znaków")
    private String lastname;
    @Size(max = 80,message = "Ulica nie może mieć powyżej 80 znaków")
    private String street;
    @Size(max = 10,message = "Numer domu nie może mieć powyżej 10 znaków")
    private String no;
    @Size(max = 80,message = "Miasto nie może mieć powyżej 80 znaków")
    private String town;
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Błędny format kodu pocztowego XX-XXX")
    private String code;
    private int status;
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String create_data;
    @ManyToMany
    @JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "name_id"))
    private Set<Products> products;
    //private int id;

    public Orders() {
    }





}

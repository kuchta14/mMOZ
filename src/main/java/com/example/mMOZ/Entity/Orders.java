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
    @NotBlank
    @Size(max = 80)
    private String firstname;
    @NotBlank
    @Size(max = 80)
    private String lastname;
    @Size(max = 80)
    private String street;
    @Size(max = 10)
    private String no;
    @Size(max = 80)
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

    public Orders() {
    }



}

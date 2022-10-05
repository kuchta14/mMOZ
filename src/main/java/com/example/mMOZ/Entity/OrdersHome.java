package com.example.mMOZ.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrdersHome {

@Id
    private Long order_number;
    private String firstname;
    private String lastname;
    private String create_data;
    private int status;
    private double suma;
    private String fa;
}

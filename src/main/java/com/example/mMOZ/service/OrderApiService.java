package com.example.mMOZ.service;


import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.repository.OrdersRepository;
import com.example.mMOZ.repository.ProductsRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;



@Service
public class OrderApiService {
    private final OrdersRepository OrdersRepo;
    private final ProductsRepository productsRepository;

  
    public OrderApiService(OrdersRepository ordersRepo, ProductsRepository productsRepository) {
        OrdersRepo = ordersRepo;
        this.productsRepository = productsRepository;
    }

    private static final int STANDARD_LENGTH = 9;
    final int nowYear = LocalDate.now().getYear();

    private static final RandomStringGenerator GENERATOR = new RandomStringGenerator.Builder()
            .usingRandom(new SecureRandom()::nextInt)
            .selectFrom("1234567890".toCharArray())
            .build();

    public List<Orders> findAll(){
        return OrdersRepo.findAll();
    }

    public void save(Orders orders, List<String> product){

        orders.setOrder_number(Long.valueOf(nowYear + GENERATOR.generate(STANDARD_LENGTH)));
        orders.setCreate_data(String.valueOf(LocalDateTime.now()));
        orders.setStatus(1);
        List<Products> products = productsRepository.findByNameIsIn(product);
        orders.setProducts(new HashSet<Products>(products));
        OrdersRepo.save(orders);
    }

    public void update(Orders orders){
        OrdersRepo.save(orders);
    }

    public Orders findByOrderNumber(long order_number){
        return OrdersRepo.findByorderNumber(order_number);
    }

    public List<Orders> findTop10ByOrderNumberDesc(){ return OrdersRepo.findTop10ByOrderNumberDesc();}


}

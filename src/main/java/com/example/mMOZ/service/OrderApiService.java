package com.example.mMOZ.service;


import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.OrdersHome;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.Rest.sendOrder;
import com.example.mMOZ.repository.OrdersRepository;
import com.example.mMOZ.repository.ProductsRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.*;
import java.util.HashSet;
import java.util.List;



@Service
public class OrderApiService {
    private final OrdersRepository OrdersRepo;
    private final ProductsRepository productsRepository;

    private final sendOrder sendOrder;

  
    public OrderApiService(OrdersRepository ordersRepo, ProductsRepository productsRepository, com.example.mMOZ.Rest.sendOrder sendOrder) {
        OrdersRepo = ordersRepo;
        this.productsRepository = productsRepository;
        this.sendOrder = sendOrder;
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

        if (sendOrder.sendOrderErp(orders.getOrder_number()) == HttpStatus.OK) {
            orders.setStatus(1);
        }
        else {
            orders.setStatus(0);
        }
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

    public List<OrdersHome> findTop10ByOrderNumberDesc2(){ return OrdersRepo.findTop10ByOrderNumberDesc2();}
}

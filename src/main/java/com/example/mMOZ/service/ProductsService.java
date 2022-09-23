package com.example.mMOZ.service;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> findAll(){
        return productsRepository.findAll();
    }


    public List<Products> findByOrderNumberProducts(long order_number){
        return productsRepository.findByorderNumberProducts(order_number);
    }
}

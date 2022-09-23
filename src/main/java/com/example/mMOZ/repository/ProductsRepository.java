package com.example.mMOZ.repository;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductsRepository extends JpaRepository<Products, String> {

    List<Products> findAll();
    List<Products> findByNameIsIn(List<String> name);

    @Query(value = "SELECT b.* FROM orders_products a JOIN products b ON a.name_id=b.name WHERE a.order_id = ?1",nativeQuery = true)
    List<Products> findByorderNumberProducts(long order_number);

}

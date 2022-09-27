package com.example.mMOZ.repository;

import com.example.mMOZ.Entity.Orders;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@EnableJpaRepositories
public interface OrdersRepository extends JpaRepository<Orders, Integer> {


List<Orders> findAll();
@Query(value = "SELECT * FROM orders a WHERE a.order_number = ?1",nativeQuery = true)
Orders findByorderNumber(long order_number);

@Query(value = "SELECT b.* FROM orders b order by b.create_data DESC LIMIT 5",nativeQuery = true)
List<Orders> findTop10ByOrderNumberDesc();
}

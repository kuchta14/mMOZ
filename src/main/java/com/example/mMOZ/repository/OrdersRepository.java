package com.example.mMOZ.repository;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.OrdersHome;
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

@Query(value = "SELECT b.order_number,\n" +
        "       b.firstname,\n" +
        "       b.lastname,\n" +
        "       b.create_data,\n" +
        "       b.status,\n" +
        "       sum(price) as suma,\n" +
        "       COALESCE(concat('FAV/',c.id,'/2022'),'') as fa\n" +
        "FROM orders b\n" +
        "JOIN orders_products op on b.order_number = op.order_id\n" +
        "JOIN products p on p.name = op.name_id\n" +
        "LEFT JOIN invoice c ON b.order_number=c.order_number\n" +
        "group by b.order_number,b.create_data\n" +
        "order by b.create_data DESC LIMIT 5",nativeQuery = true)
List<OrdersHome> findTop10ByOrderNumberDesc2();

    @Query(value = "SELECT b.* FROM orders b order by b.create_data DESC LIMIT 5",nativeQuery = true)
    List<Orders> findTop10ByOrderNumberDesc();
}

package com.example.mMOZ.repository;

import com.example.mMOZ.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * FROM invoice a WHERE a.order_number = ?1",nativeQuery = true)
    Optional<Invoice> findInvoiceByOrder_numberTrue(long order_number);

    @Query(value = "SELECT * FROM invoice a WHERE a.order_number = ?1 LIMIT 1",nativeQuery = true)
    Invoice findInvoiceByOrder_number(long order_number);


    @Query(value = "SELECT a.id FROM invoice a WHERE a.order_number in ?1",nativeQuery = true)
    List<Integer> findInvoiceByOrder_numberNumberDoc(List<Long> order_number);
}

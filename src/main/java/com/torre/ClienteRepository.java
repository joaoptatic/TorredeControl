package com.torre;


import com.torre.crm.controller.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    static void deleteBYId(Long id) {
    }
}
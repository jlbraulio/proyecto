package com.example.microservicio.repository;

import com.example.microservicio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByRfc(String rfc);
}

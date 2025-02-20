package com.example.microservicio.repository;

import com.example.microservicio.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}

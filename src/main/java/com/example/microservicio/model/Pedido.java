package com.example.microservicio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idPedido;
        private String nombreCliente;
        private String rfc;
        private String nombreTienda;
        private Double totalPagar;

        @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JsonManagedReference
        private List<DetallePedido> detallePedidos;

        // Métodos de conveniencia
        public void agregarDetalle(DetallePedido detalle) {
                detallePedidos.add(detalle);
                detalle.setPedido(this);
        }
}

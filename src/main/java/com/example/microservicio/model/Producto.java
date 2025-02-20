package com.example.microservicio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private Double precio;
    private Integer cantidad;

}

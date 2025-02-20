package com.example.microservicio.service;

import com.example.microservicio.model.DetallePedido;
import com.example.microservicio.model.Producto;

import java.util.List;

public interface IDetalleService {


    DetallePedido registrar(DetallePedido detallePedido);

    DetallePedido modificar(DetallePedido detallePedido);

    List<DetallePedido> listar();
}

package com.example.microservicio.service;

import com.example.microservicio.model.DetallePedido;
import com.example.microservicio.model.Pedido;
import com.example.microservicio.model.Producto;

import java.util.List;

public interface IPedidoService {


    Pedido registrar(Pedido Pedido) throws Exception;

    List<Pedido> listar();

    List<Pedido> listaPorRFC(String rfc);

}

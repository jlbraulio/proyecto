package com.example.microservicio.service;

import com.example.microservicio.model.Producto;
import com.example.microservicio.repository.IProductoRepository;

import java.util.List;

public interface IProductoService {


    Producto registrar(Producto producto);

    Producto modificar(Producto producto);

    List<Producto> listar();

    Producto listarPorId(int id);
}

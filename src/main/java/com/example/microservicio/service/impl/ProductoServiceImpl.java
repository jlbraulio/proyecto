package com.example.microservicio.service.impl;

import com.example.microservicio.model.Producto;
import com.example.microservicio.repository.IProductoRepository;
import com.example.microservicio.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository productoRepo;

    @Override
    public Producto registrar(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoRepo.findAll();
    }

    @Override
    public Producto listarPorId(int id) {
        Optional<Producto> producto = productoRepo.findById(id);
        return producto.orElseGet(Producto::new);
    }
}

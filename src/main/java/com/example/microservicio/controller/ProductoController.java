package com.example.microservicio.controller;

import com.example.microservicio.model.Producto;
import com.example.microservicio.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return new ResponseEntity<List<Producto>>(productoService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> registrar(@RequestBody Producto producto) {
        Producto objeConsulta = productoService.registrar(producto);
        return new ResponseEntity<Producto>(objeConsulta, HttpStatus.CREATED);
    }
}

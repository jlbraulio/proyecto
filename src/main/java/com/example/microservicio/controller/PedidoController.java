package com.example.microservicio.controller;

import com.example.microservicio.model.DetallePedido;
import com.example.microservicio.model.Pedido;
import com.example.microservicio.model.Producto;
import com.example.microservicio.service.IPedidoService;
import com.example.microservicio.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/api/pedidos")
public class PedidoController {

    private final IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return new ResponseEntity<List<Pedido>>(pedidoService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido) throws Exception {
        Pedido objeConsulta = pedidoService.registrar(pedido);
        return new ResponseEntity<Pedido>(objeConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/rfc/{rfc}")
    public ResponseEntity<List<Pedido>> listar(@PathVariable String rfc) {
        return new ResponseEntity<List<Pedido>> (pedidoService.listaPorRFC(rfc), HttpStatus.OK);
    }

}

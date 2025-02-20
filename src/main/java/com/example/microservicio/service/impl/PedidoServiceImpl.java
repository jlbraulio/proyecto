package com.example.microservicio.service.impl;

import com.example.microservicio.model.DetallePedido;
import com.example.microservicio.model.Pedido;
import com.example.microservicio.model.Producto;
import com.example.microservicio.repository.IDetallePedidoRepository;
import com.example.microservicio.repository.IPedidoRepository;
import com.example.microservicio.repository.IProductoRepository;
import com.example.microservicio.service.IPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoServiceImpl implements IPedidoService {

    private final IDetallePedidoRepository detallePedidoRepository;
    private final IPedidoRepository pedidoRepository;
    private final IProductoRepository productoRepository;

    @Override
    public Pedido registrar(Pedido pedido) throws Exception {

        List<Producto> productos = getProductos(pedido);
        totalPrecio(pedido, productos);

        if (pedido.getDetallePedidos() != null) {
            for (DetallePedido detalle : pedido.getDetallePedidos()) {
                detalle.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);

    }

    private static void totalPrecio(Pedido pedido, List<Producto> productos) {
        Double total = productos
                .stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        pedido.setTotalPagar(total);
    }

    private List<Producto> getProductos(Pedido pedido) {
        List<Producto> productos = pedido.getDetallePedidos()
                .stream()
                .map(detalle -> productoRepository.findById(detalle.getProducto().getIdProducto()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        return productos;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public List<Pedido> listaPorRFC(String rfc) {
        return pedidoRepository.findByRfc(rfc);
    }
}
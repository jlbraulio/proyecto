package com.example.microservicio.service.impl;

import com.example.microservicio.model.DetallePedido;
import com.example.microservicio.repository.IDetallePedidoRepository;
import com.example.microservicio.service.IDetalleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DetallePedidoServiceImpl implements IDetalleService {

    private final IDetallePedidoRepository detallePedidoRepository;

    @Override
    public DetallePedido registrar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido modificar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public List<DetallePedido> listar() {
        return detallePedidoRepository.findAll();
    }
}

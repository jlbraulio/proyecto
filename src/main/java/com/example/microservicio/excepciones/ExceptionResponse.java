package com.example.microservicio.excepciones;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse {
    private LocalDateTime fechaHora;
    private String mensaje;
    private String detalles;
}


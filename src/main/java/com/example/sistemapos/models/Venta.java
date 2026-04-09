package com.example.sistemapos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "venta")
public class Venta {
    @Id
    private String id;

    // 1. Datos Generales
    private LocalDateTime fecha;
    private String idUsuario;
    private String cliente;
    // 2. Dinero y Pagos
    private String metodoPago;
    private Double total;
    List<DetalleVenta> detalles;
}

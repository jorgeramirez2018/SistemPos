package com.example.sistemapos.models;

import lombok.Data;

@Data
public class DetalleVenta {
    private String idProducto;
    private String codigoBarras;    // Útil por si se necesita hacer una devolución
    private String nombreProducto;  // La "foto" del nombre
    private int cantidad;           // Cuántos se llevó
    private Double precioUnitario;  // A cómo se lo vendiste hoy
    private Double subtotal;        // cantidad * precioUnitario

}

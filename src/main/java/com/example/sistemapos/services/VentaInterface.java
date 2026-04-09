package com.example.sistemapos.services;

import com.example.sistemapos.models.User;
import com.example.sistemapos.models.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaInterface {
    List<Venta> obtenerVentas();
    Optional<Venta> obtenerIdVentas(String id);
    Venta guardarVenta (Venta guardarVenta);
    public String borrarVenta(String id);
    void actualizarVenta (String id,Venta actualizarVenta);
}

package com.example.sistemapos.services;

import com.example.sistemapos.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {
    List<Product> obtenerProductos();
    Optional<Product> obtenerProducto(String id);
    Product guardarDatos(Product guardarProducto);
    String borrarProducto(String id);
    void actualizarProducto (String id, Product actualizarProducto);
}

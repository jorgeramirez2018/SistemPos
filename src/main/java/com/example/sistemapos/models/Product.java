package com.example.sistemapos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productos")
public class Product {

    @Id
    private String id_user;
    private String codigo_barras;
    private String nombre;
    private String descripcion;
    private Double precio_compra;
    private Double precio_venta;
    private int stock_actual;
    private int stock_minimo;
    private String categoria;
    private String estado;

}

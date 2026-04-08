package com.example.sistemapos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class User {
    @Id
    private String id;
    private String documentoIdentidad;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol;
    private String estado;
}

package com.example.sistemapos.services;

import com.example.sistemapos.models.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    List<User> obtenerUsuarios();
    Optional<User> obtenerUsuarioId(String id);
    User guardarUsuario (User guardarUser);
    public String eliminarUsuario(String id);
    void actualizarUsuario (String id,User actualizarUsuario);

}

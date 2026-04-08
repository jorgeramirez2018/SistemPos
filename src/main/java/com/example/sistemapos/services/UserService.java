package com.example.sistemapos.services;

import com.example.sistemapos.models.User;
import com.example.sistemapos.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserInterface{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> obtenerUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> obtenerUsuarioId(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User guardarUsuario(User guardarUser) {
        return userRepository.save(guardarUser);
    }

    @Override
    public String eliminarUsuario(String id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Se elimino el id con exito";
        }else {
            return "El id no existe";
        }

    }

    @Override
    public void actualizarUsuario(String id, User actualizarUsuario) {
        User update = userRepository.findById(id).orElse(null);
        if (update!=null){
            update.setNombre(actualizarUsuario.getNombre());
            update.setEstado(actualizarUsuario.getEstado());
            update.setApellido(actualizarUsuario.getApellido());
            update.setEmail(actualizarUsuario.getEmail());
            update.setEstado(actualizarUsuario.getEstado());
            update.setDocumentoIdentidad(actualizarUsuario.getDocumentoIdentidad());
            update.setPassword(actualizarUsuario.getPassword());
            userRepository.save(update);
        }else {
            throw new RuntimeException("No se encontro id relacionado: " + id);
        }

    }
}

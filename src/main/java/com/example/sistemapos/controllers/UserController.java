package com.example.sistemapos.controllers;

import com.example.sistemapos.models.User;
import com.example.sistemapos.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserInterface userService;
    @Autowired
    public UserController(UserInterface userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> listarUsuarios(){
        return userService.obtenerUsuarios();
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerUsuarioId(@PathVariable("id") String id){
        userService.obtenerUsuarioId(id);
        return ResponseEntity.ok("Se realizo la busqueda por id"+ id);
    }
    @PostMapping("/save")
    public ResponseEntity<String> guardarUser(@RequestBody User guardarUser){
        User guardar = userService.guardarUsuario(guardarUser);
        return ResponseEntity.ok("Se ha guardado correctamente");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> borrarUser (@PathVariable("id") String id){
        userService.eliminarUsuario(id);
        return  ResponseEntity.ok("Se elimino con exito");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity <String> updateUser (@PathVariable("id") String id,@RequestBody User saveUpdate){
        userService.actualizarUsuario(id,saveUpdate);
        return ResponseEntity.ok("Se actualizo correctamente");
    }


}

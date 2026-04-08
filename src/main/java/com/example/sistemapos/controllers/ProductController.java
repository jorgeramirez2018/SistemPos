package com.example.sistemapos.controllers;

import com.example.sistemapos.models.Product;
import com.example.sistemapos.services.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductInterface userService;
    @Autowired
    public ProductController(ProductInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Product> obtenerUsiarios(){
        return userService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerId(@PathVariable("id") String id ){
    userService.obtenerProducto(id);
     return ResponseEntity.ok("Se guardo");
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarDatos(@RequestBody Product guardar){

        Product usuarioGuardado = userService.guardarDatos(guardar);
        return ResponseEntity.ok("Guardado exitosamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") String id){
        System.out.println("ID recibido: " + id);

        if (id != null && !id.trim().isEmpty()) {

            String respuesta = userService.borrarProducto(id);
            if (respuesta.equals("No se encontro id relacionado")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
            }

            // 3. Si no fue error, mandamos un 200 (OK) con el mensaje de éxito
            return ResponseEntity.ok(respuesta);

        } else {
            return ResponseEntity.badRequest().body("Error: El ID no puede estar vacío");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable("id")String id, Product acualizaar){
        userService.actualizarProducto(id,acualizaar);
        return ResponseEntity.ok("Seactualizo");
    }

}

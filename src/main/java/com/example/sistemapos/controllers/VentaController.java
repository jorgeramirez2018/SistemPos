package com.example.sistemapos.controllers;

import com.example.sistemapos.models.User;
import com.example.sistemapos.models.Venta;
import com.example.sistemapos.services.VentaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private final VentaInterface ventaService;

    public VentaController(VentaInterface ventaService) {
        this.ventaService = ventaService;

    }

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerVentaId(@PathVariable("id") String id) {
        ventaService.obtenerIdVentas(id);
        return ResponseEntity.ok("Se obtuvo la venta por id: " + id);
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarVenta(@RequestBody Venta guardarVenta) {
        try {
            ventaService.guardarVenta(guardarVenta);
            return ResponseEntity.ok("Se guardo la venta ");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrarVenta(@PathVariable String id) {
        ventaService.borrarVenta(id);
        return ResponseEntity.ok("Se elimino con exito");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizarVenta(@PathVariable("id") String id, @RequestBody Venta acualizarVenta) {
        ventaService.actualizarVenta(id, acualizarVenta);
        return ResponseEntity.ok("Venta actualizada correctamente");
    }
}

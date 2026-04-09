package com.example.sistemapos.services;

import com.example.sistemapos.models.DetalleVenta;
import com.example.sistemapos.models.Venta;
import com.example.sistemapos.repositories.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VentaService implements VentaInterface{
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> obtenerIdVentas(String id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta guardarVenta(Venta guardarVenta) {
        return ventaRepository.save(guardarVenta);
    }

    @Override
    public String borrarVenta(String id) {
        ventaRepository.deleteById(id);
        return "Se borro con exito";
    }


    @Override
    public void actualizarVenta(String id, Venta actualizarVenta) {
        Venta update = ventaRepository.findById(id).orElse(null);

        if (update!=null){
          update.setCliente(actualizarVenta.getCliente());
          update.setFecha(actualizarVenta.getFecha());
          update.setTotal(actualizarVenta.getTotal());
          update.setMetodoPago(actualizarVenta.getMetodoPago());
          update.setIdUsuario(actualizarVenta.getIdUsuario());
          update.setDetalles(actualizarVenta.getDetalles());
          ventaRepository.save(update);

        }else {
            throw new RuntimeException("No se encontro id relacionado con : " + id);
        }

    }
}

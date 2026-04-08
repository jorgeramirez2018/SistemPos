package com.example.sistemapos.services;

import com.example.sistemapos.models.Product;
import com.example.sistemapos.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductInterface {
    private final ProductRepository userRepository;

    public ProductService(ProductRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Product> obtenerProductos() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Product> obtenerProducto(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Product guardarDatos(Product guardarUsuario) {
        return userRepository.save(guardarUsuario);
    }

    @Override
    public String borrarProducto(String id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Se elimino con exito";
        }else {
            return "No se encontro id relacionado";
        }

    }

    @Override
    public void actualizarProducto(String id, Product actualizarUser) {
        Product update = userRepository.findById(id).orElse(null);

        if (update != null){
            update.setNombre(actualizarUser.getNombre());
            update.setCategoria(actualizarUser.getCategoria());
            update.setDescripcion(actualizarUser.getDescripcion());
            update.setCodigo_barras(actualizarUser.getCodigo_barras());
            update.setPrecio_compra(actualizarUser.getPrecio_compra());
            update.setStock_actual(actualizarUser.getStock_actual());
            update.setStock_minimo(actualizarUser.getStock_minimo());
            update.setPrecio_venta(actualizarUser.getPrecio_venta());
            update.setEstado(actualizarUser.getEstado());
        }else {
            throw new RuntimeException("No se encontro id relacionado para actualizar" + id);
        }
    }
}

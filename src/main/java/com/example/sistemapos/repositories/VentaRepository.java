package com.example.sistemapos.repositories;

import com.example.sistemapos.models.User;
import com.example.sistemapos.models.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends MongoRepository<Venta, String> {
}

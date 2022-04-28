package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends MongoRepository<Cliente, UUID> {
    Optional<Cliente> findByCorreo(String correo);
}

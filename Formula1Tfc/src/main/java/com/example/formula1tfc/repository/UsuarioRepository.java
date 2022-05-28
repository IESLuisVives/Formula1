package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
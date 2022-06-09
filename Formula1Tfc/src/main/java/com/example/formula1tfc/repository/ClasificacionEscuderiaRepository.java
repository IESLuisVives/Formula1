package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.ClasificacionEscuderia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionEscuderiaRepository extends MongoRepository<ClasificacionEscuderia, String> {
}

package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Clasificacion;
import com.example.formula1tfc.models.Pilotos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClasificacionRepository extends MongoRepository<Clasificacion, Integer> {
}

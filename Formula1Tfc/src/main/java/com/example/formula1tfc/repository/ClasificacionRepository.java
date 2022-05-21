package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.ClasificacionPiloto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends MongoRepository<ClasificacionPiloto, String> {
}

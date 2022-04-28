package com.example.formula1tfc.repository;


import com.example.formula1tfc.models.Pilotos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotosRepository extends MongoRepository<Pilotos, Integer> {
}

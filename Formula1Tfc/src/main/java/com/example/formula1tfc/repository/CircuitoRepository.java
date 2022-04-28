package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Circuito;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface CircuitoRepository extends MongoRepository<Circuito, Integer> {

}

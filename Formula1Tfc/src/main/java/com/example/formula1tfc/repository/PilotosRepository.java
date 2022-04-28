package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Admin;
import com.example.formula1tfc.models.Pilotos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PilotosRepository extends MongoRepository<Pilotos, Integer> {
}

package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, Long> {
}

package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface AdminRepository extends MongoRepository<Admin, UUID> {
    Optional<Admin> findAdminByCorreo(String correo);
}


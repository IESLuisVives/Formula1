package com.example.formula1tfc.repository;

import com.example.formula1tfc.models.Noticia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends MongoRepository<Noticia,String> {
}

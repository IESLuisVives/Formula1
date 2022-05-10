package com.example.formula1tfc;

import com.example.formula1tfc.controller.AdminController;
import com.example.formula1tfc.models.Admin;
import com.example.formula1tfc.models.Clasificacion;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.models.TipoEscuderia;
import com.example.formula1tfc.repository.AdminRepository;
import com.example.formula1tfc.repository.PilotosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Formula1TfcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Formula1TfcApplication.class, args);
    }
    @Bean
    public CommandLineRunner initDatos(AdminRepository adminRepository, PilotosRepository pilotosRepository){
        return (args) -> {
            adminRepository.deleteAll();
            pilotosRepository.deleteAll();
            adminRepository.insert(new Admin("Saul", "saul@gmail.com", "admin", "url"));
            pilotosRepository.insert(new Pilotos(1,"Fernando Alonso", "40", "imagen", TipoEscuderia.ALPINE.name(),new Clasificacion(1,new ArrayList<>())));
        };
    }
}

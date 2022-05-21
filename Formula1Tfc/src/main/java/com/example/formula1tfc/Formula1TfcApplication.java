package com.example.formula1tfc;

import com.example.formula1tfc.models.Admin;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.models.TipoEscuderia;
import com.example.formula1tfc.repository.AdminRepository;
import com.example.formula1tfc.repository.PilotosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

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

            //Pilotos
            pilotosRepository.insert(new Pilotos(1,"Fernando Alonso", "40", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(2,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(3,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(4,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(5,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(6,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(7,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(8,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(9,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(10,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(11,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(12,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(13,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(14,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(15,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(16,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(17,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(18,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(19,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(20,"Steban Ocon", "25", "imagen", TipoEscuderia.ALPINE.name()));
        };
    }
}

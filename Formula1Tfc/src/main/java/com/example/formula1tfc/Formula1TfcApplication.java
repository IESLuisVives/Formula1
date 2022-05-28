package com.example.formula1tfc;

import com.example.formula1tfc.dto.CreateUserDTO;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.models.TipoEscuderia;
import com.example.formula1tfc.models.UserRole;
import com.example.formula1tfc.repository.PilotosRepository;
import com.example.formula1tfc.repository.UsuarioRepository;
import com.example.formula1tfc.service.uploads.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Formula1TfcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Formula1TfcApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner initDatos(PilotosRepository pilotosRepository, UsuarioService usuarioRepository, UsuarioRepository repo){
        return (args) -> {

            pilotosRepository.deleteAll();
            repo.deleteAll();
            usuarioRepository.saveUsuario(new CreateUserDTO("Saul@gmail.com","Saul","1234","imagen", Collections.singleton(UserRole.ADMIN)));
            //Pilotos
            pilotosRepository.insert(new Pilotos(1,"Fernando Alonso", "40", "https://www.formula1.com/content/fom-website/en/drivers/fernando-alonso/_jcr_content/image.img.1920.medium.jpg/1647334212592.jpg", TipoEscuderia.ALPINE.name()));
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

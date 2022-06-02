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
            pilotosRepository.insert(new Pilotos(1,"Fernando Alonso", "40", "https://www.formula1.com/content/dam/fom-website/drivers/F/FERALO01_Fernando_Alonso/feralo01.png.transform/2col/image.png", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(2,"Steban Ocon", "25", "https://www.formula1.com/content/dam/fom-website/drivers/E/ESTOCO01_Esteban_Ocon/estoco01.png.transform/2col/image.png", TipoEscuderia.ALPINE.name()));
            pilotosRepository.insert(new Pilotos(3,"Max Verstappen", "24", "https://www.formula1.com/content/dam/fom-website/drivers/M/MAXVER01_Max_Verstappen/maxver01.png.transform/2col/image.png", TipoEscuderia.REDBULL.name()));
            pilotosRepository.insert(new Pilotos(4,"Sergio Perez", "32", "https://www.formula1.com/content/dam/fom-website/drivers/S/SERPER01_Sergio_Perez/serper01.png.transform/2col/image.png", TipoEscuderia.REDBULL.name()));
            pilotosRepository.insert(new Pilotos(5,"Charles Leclerc", "24", "https://www.formula1.com/content/dam/fom-website/drivers/C/CHALEC01_Charles_Leclerc/chalec01.png.transform/2col/image.png", TipoEscuderia.FERRARI.name()));
            pilotosRepository.insert(new Pilotos(6,"Carlos Sainz", "27", "https://www.formula1.com/content/dam/fom-website/drivers/C/CARSAI01_Carlos_Sainz/carsai01.png.transform/2col/image.png", TipoEscuderia.FERRARI.name()));
            pilotosRepository.insert(new Pilotos(7,"George Russell", "24", "https://www.formula1.com/content/dam/fom-website/drivers/G/GEORUS01_George_Russell/georus01.png.transform/2col/image.png", TipoEscuderia.MERCEDES.name()));
            pilotosRepository.insert(new Pilotos(8,"Lewis Hamilton", "37", "https://www.formula1.com/content/dam/fom-website/drivers/L/LEWHAM01_Lewis_Hamilton/lewham01.png.transform/2col/image.png", TipoEscuderia.MERCEDES.name()));
            pilotosRepository.insert(new Pilotos(9,"Lando Norris", "22", "https://www.formula1.com/content/dam/fom-website/drivers/L/LANNOR01_Lando_Norris/lannor01.png.transform/2col/image.png", TipoEscuderia.MCLAREN.name()));
            pilotosRepository.insert(new Pilotos(10,"Daniel Ricciardo", "32", "https://www.formula1.com/content/dam/fom-website/drivers/D/DANRIC01_Daniel_Ricciardo/danric01.png.transform/2col/image.png", TipoEscuderia.MCLAREN.name()));
            pilotosRepository.insert(new Pilotos(11,"Kevin Magnussen", "29", "https://www.formula1.com/content/dam/fom-website/drivers/K/KEVMAG01_Kevin_Magnussen/kevmag01.png.transform/2col/image.png", TipoEscuderia.HAAS.name()));
            pilotosRepository.insert(new Pilotos(12,"Mick Schumacher", "23", "https://www.formula1.com/content/dam/fom-website/drivers/M/MICSCH02_Mick_Schumacher/micsch02.png.transform/2col/image.png", TipoEscuderia.HAAS.name()));
            pilotosRepository.insert(new Pilotos(13,"Sebastian Vettel", "34", "https://www.formula1.com/content/dam/fom-website/drivers/S/SEBVET01_Sebastian_Vettel/sebvet01.png.transform/2col/image.png", TipoEscuderia.ASTONMARTIN.name()));
            pilotosRepository.insert(new Pilotos(14,"Lance Stroll", "23", "https://www.formula1.com/content/dam/fom-website/drivers/L/LANSTR01_Lance_Stroll/lanstr01.png.transform/2col/image.png", TipoEscuderia.ASTONMARTIN.name()));
            pilotosRepository.insert(new Pilotos(15,"Alex Albon", "26", "https://www.formula1.com/content/dam/fom-website/drivers/A/ALEALB01_Alexander_Albon/alealb01.png.transform/2col/image.png", TipoEscuderia.WILLIAMS.name()));
            pilotosRepository.insert(new Pilotos(16,"Nicholas Latifi", "26", "https://www.formula1.com/content/dam/fom-website/drivers/N/NICLAF01_Nicholas_Latifi/niclaf01.png.transform/2col/image.png", TipoEscuderia.WILLIAMS.name()));
            pilotosRepository.insert(new Pilotos(17,"Yuki Tsunoda", "22", "https://www.formula1.com/content/dam/fom-website/drivers/Y/YUKTSU01_Yuki_Tsunoda/yuktsu01.png.transform/2col/image.png", TipoEscuderia.ALPHATAURI.name()));
            pilotosRepository.insert(new Pilotos(18,"Pierre Gasly", "26", "https://www.formula1.com/content/dam/fom-website/drivers/P/PIEGAS01_Pierre_Gasly/piegas01.png.transform/2col/image.png", TipoEscuderia.ALPHATAURI.name()));
            pilotosRepository.insert(new Pilotos(19,"Valtteri Bottas", "32", "https://www.formula1.com/content/dam/fom-website/drivers/V/VALBOT01_Valtteri_Bottas/valbot01.png.transform/2col/image.png", TipoEscuderia.ALFAROMEO.name()));
            pilotosRepository.insert(new Pilotos(20,"Guanyu Zhou", "23", "https://www.formula1.com/content/dam/fom-website/drivers/G/GUAZHO01_Guanyu_Zhou/guazho01.png.transform/2col/image.png", TipoEscuderia.ALFAROMEO.name()));
        };
    }
}

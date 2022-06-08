package com.example.formula1tfc;

import com.example.formula1tfc.dto.UsuarioDTO;
import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.models.TipoEscuderia;
import com.example.formula1tfc.repository.CircuitoRepository;
import com.example.formula1tfc.repository.PilotosRepository;
import com.example.formula1tfc.repository.UsuarioRepository;
import com.example.formula1tfc.service.uploads.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    public CommandLineRunner initDatos(PilotosRepository pilotosRepository, UsuarioService usuarioRepository, UsuarioRepository repo, CircuitoRepository circuitoRepository){
        return (args) -> {

            pilotosRepository.deleteAll();
            circuitoRepository.deleteAll();
            repo.deleteAll();
            usuarioRepository.saveUsuario(new UsuarioDTO("1","Saul","Saul2@gmail.com","1234","imagen"));
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


            //circuitos
            circuitoRepository.insert(new Circuito(1,"Bahrain","Bahrain International","1:31.447","5.412 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Bahrain%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(2,"Arabia Saudi","Jeddah Corniche","1:30.734","6.174 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Saudi%20Arabia%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(3,"Australia","Albert Park","1:20.260","5.278 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Australia%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(4,"Italia","Autodromo Enzo","1:15.484","4.909 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Emilia%20Romagna%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(5,"Estados Unidos","Miami International","1:31.361","5.412 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Miami%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(6,"España","Circuit de Barcelona","1:18.149","4.675 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Spain%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(7,"Monaco","Circuit de Monaco","1:12.909","3.337 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Monte%20Carlo%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(8,"Azerbaijan","Baku City","1:43.009","6.003 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Azerbaijan%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(9,"Canada","Gilles-Villeneuve","1:13.078","4.361 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Canada%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(10,"Gran Bretaña","Silverstone","1:27.097","5.891 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Great%20Britain%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(11,"Austria","Red Bull Ring","1:05.619","4.318 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Austria%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(12,"Francia","Paul Ricard","1:32.740","5.842 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/France%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(13,"Hungria","Hungaroring","1:16.627","4.381 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Hungar%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(14,"Belgica","Spa-Francorchamps","1:46.286","7.004 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Belgium%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(15,"Holanda","Zandvoort","1:11.097","4.259 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Netherlands%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(16,"Italia","Monza","1:21.046","5.793 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Italy%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(17,"Singapore","Marina Bay","1:41.905","5.063 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Singapor%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(18,"Japon","Suzuka","1:30.983","5.807 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Japan%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(19,"Estados Unidos","The Americas","1:36.169","5.513 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/USA%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(20,"Mexico","Hermanos Rodríguez","1:17.774","4.304 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Mexico%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(21,"Brasil","Autódromo José Carlos","1:10.540","4.309 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Brazil%20carbon.png.transform/3col/image.png"));
            circuitoRepository.insert(new Circuito(22,"Abu Dahbi","Yas Marina","1:26.103","5.281 KM","https://www.formula1.com/content/dam/fom-website/2018-redesign-assets/Track%20icons%204x3/Abu%20Dhab%20carbon.png.transform/3col/image.png"));

        };
    }
}

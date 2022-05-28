package com.example.formula1tfc.service.uploads;


import com.example.formula1tfc.models.ClasificacionEscuderia;
import com.example.formula1tfc.models.ClasificacionPiloto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class ClasificacionService {

    private String urlReal = "https://www.formula1.com/en/results.html/2022/drivers.html";
    private String urlReal2 = "https://www.formula1.com/en/results.html/2022/team.html";

    Set<ClasificacionPiloto> responseDTOS = new HashSet<>();
    Set<ClasificacionEscuderia> responseDTOS2 = new HashSet<>();

    public Set<ClasificacionPiloto> extraerClasificacionPilotos(){
        try{
            Document document = Jsoup.connect(urlReal).get();

            Elements element = document.getElementsByTag("tr");

            Elements prueba =  new Elements();

            prueba.addAll(element);


            for (Element ads: prueba){
                ClasificacionPiloto responseDTO = new ClasificacionPiloto();
                responseDTO.setNombrePiloto(ads.getElementsByClass("hide-for-mobile").html());
                responseDTO.setBandera(ads.getElementsByClass("dark semi-bold uppercase").text());
                responseDTO.setPuntos(ads.getElementsByClass("dark bold").html());
                responseDTO.setPosicion(ads.getElementsByClass("limiter").next().html());

                if (!Objects.equals(responseDTO.getNombrePiloto(), "") && !Objects.equals(responseDTO.getPuntos(), "")){
                    responseDTOS.add(responseDTO);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseDTOS;
    }

    public Set<ClasificacionEscuderia> extraerClasificacionEscuderias(){
        try{
            Document document = Jsoup.connect(urlReal2).get();

            Elements element = document.getElementsByTag("tr");

            Elements prueba =  new Elements();

            prueba.addAll(element);


            for (Element ads: prueba){
                ClasificacionEscuderia responseDTO = new ClasificacionEscuderia();
                responseDTO.setNombreEscuderia(ads.getElementsByClass("dark bold uppercase ArchiveLink").text());
                responseDTO.setPuntos(ads.getElementsByClass("dark bold").html());
                responseDTO.setPosicion(ads.getElementsByClass("limiter").next().html());

                if (!Objects.equals(responseDTO.getNombreEscuderia(), "") && !Objects.equals(responseDTO.getPuntos(), "")){
                    responseDTOS2.add(responseDTO);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseDTOS2;
    }
}

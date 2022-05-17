package com.example.formula1tfc.service.uploads;

import com.example.formula1tfc.models.Noticia;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class NoticiaService {
    String urlReal="https://www.caranddriver.com/es/formula-1/";

    Set<Noticia> responseDTOS = new HashSet<>();

    public Set<Noticia> extraerNoticiasPagina(){
        try{
            Document document = Jsoup.connect(urlReal).get();
            Element element = document.getElementsByClass("feed-block-column-content").first();
            Elements elements = element.getElementsByTag("a");
            for (Element ads: elements) {
                Noticia responseDTO = new Noticia();


                    //funciona de locos responseDTO.setTitulo(ads.html());
                    responseDTO.setTitulo(ads.ownText());
                    responseDTO.setUrl("https://www.caranddriver.com/es/formula-1/"+ads.attr("href"));

                if (!Objects.equals(responseDTO.getTitulo(), "")) {
                    responseDTOS.add(responseDTO);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseDTOS;
    }
}

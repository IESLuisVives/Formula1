package com.example.formula1tfc.service.uploads;

import com.example.formula1tfc.models.Noticia;
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
public class NoticiaService {
    //@Value("${paginaWeb}")
    private String urlReal = "https://www.formulaf1.es/";

    Set<Noticia> responseDTOS = new HashSet<>();

    /*public Set<Noticia> extraerNoticiasPagina(){
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
    }*/

    public Set<Noticia> extraerNoticiasPagina2(){
        try{
            Document document = Jsoup.connect(urlReal).get();

            Element element = document.getElementsByAttributeValue("id","td_uid_9_62975726aa3c0").first();
            Elements elements = element.getElementsByTag("img");

            Elements prueba =  new Elements();

            prueba.addAll(elements);


            for (Element ads: prueba){
                Noticia responseDTO = new Noticia();

                responseDTO.setTitulo(ads.attr("title"));
                responseDTO.setImagen(ads.attr("data-img-url"));

                if (!Objects.equals(responseDTO.getTitulo(), "") && !Objects.equals(responseDTO.getImagen(), "")) {
                    responseDTOS.add(responseDTO);
                }
            }

            /*for (Element ads: elements) {
                Noticia responseDTO = new Noticia();


                //funciona de locos responseDTO.setTitulo(ads.html());
                responseDTO.setTitulo(ads.attr("title"));
                responseDTO.setUrl("https://www.caranddriver.com/es/formula-1/"+ads.attr("href"));

                if (!Objects.equals(responseDTO.getTitulo(), "")) {
                    responseDTOS.add(responseDTO);
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseDTOS;
    }
}

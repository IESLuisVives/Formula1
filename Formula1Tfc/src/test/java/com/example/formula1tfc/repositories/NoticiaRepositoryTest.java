package com.example.formula1tfc.repositories;

import com.example.formula1tfc.models.Noticia;
import com.example.formula1tfc.repository.NoticiaRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {NoticiaRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoticiaRepositoryTest {

    @MockBean
    private NoticiaRepository repository;
    private Noticia noticia;
    private List<Noticia> listaNoticia;

    @BeforeAll
    void beforeAll() {
        noticia = new Noticia("titulo","imagen");
        listaNoticia = new ArrayList<>();
        listaNoticia.add(noticia);
    }
    @Test
    @Order(1)
    public void guardar() {

        when(repository.save(noticia)).thenReturn(noticia);
        Noticia response = repository.save(noticia);
        assertAll(
                () -> assertEquals(noticia.getImagen(), response.getImagen()),
                () -> assertEquals(noticia.getTitulo(), response.getTitulo())

        );
        verify(repository, times(1)).save(noticia);
    }
    @Test
    @Order(2)
    public void getAllNoticias() {
        when(repository.findAll()).thenReturn(listaNoticia);
        assertTrue(repository.findAll().size() == listaNoticia.size());
        verify(repository, times(1)).findAll();
    }


}

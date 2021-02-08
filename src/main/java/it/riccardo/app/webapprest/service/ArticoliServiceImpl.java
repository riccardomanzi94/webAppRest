package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Articoli;
import it.riccardo.app.webapprest.model.Utenti;
import it.riccardo.app.webapprest.repository.ArticoliRepository;
import it.riccardo.app.webapprest.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ArticoliServiceImpl implements ArticoliService{

    @Autowired
    private ArticoliRepository articoliRepository;

    /*@PostConstruct
    public void setup(){

        Articoli a1 = new Articoli();
        Utenti u1 = new Utenti();

        u1.setNome("Riccardo");
        u1.setCognome("Manzi");
        u1.setEmail("riccardomanzi1994@gmail.com");

        a1.setCodArt("123456");
        a1.setDescrizione("prova articolo a1");
        a1.setUser(u1);
        articoliRepository.save(a1);
    }*/
}

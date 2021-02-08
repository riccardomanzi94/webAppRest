package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Utenti;
import it.riccardo.app.webapprest.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UtentiServiceImpl implements UtentiService{

    @Autowired
    private UtentiRepository utentiRepository;


    /*@PostConstruct
    public void setup(){

        Utenti u1 = new Utenti();
        u1.setNome("Riccardo");
        u1.setCognome("Manzi");
        u1.setEmail("riccardomanzi1994@gmail.com");
        utentiRepository.save(u1);

        Utenti u2 = new Utenti();
        u2.setNome("Giorgia");
        u2.setCognome("Campoli");
        u2.setEmail("giorgiacampoli1@gmail.com");
        utentiRepository.save(u2);
    }*/

    @Override
    public List<Utenti> getAllUsers() {

        return utentiRepository.findAll();
    }

    @Override
    public Utenti getUserById(Integer id) {
        return utentiRepository.findById(id).get();
    }
}

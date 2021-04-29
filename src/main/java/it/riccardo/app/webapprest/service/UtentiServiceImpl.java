package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.entities.Utenti;
import it.riccardo.app.webapprest.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UtentiServiceImpl implements UtentiService{

    @Autowired
    private UtentiRepository utentiRepository;


    @PostConstruct
    public void setup(){

        Utenti u1 = new Utenti();
        u1.setId(1);
        u1.setUsername("rmanzi");
        u1.setPassword("ciao");
        utentiRepository.save(u1);
    }

    @Override
    @Cacheable("utenti")
    public List<Utenti> getAllUsers() {
        return utentiRepository.findAll();
    }

    @Override
    @Cacheable("utenti")
    public Optional<Utenti> getUserById(Integer id) {
        return utentiRepository.findById(id);
    }

    @Override
    @Cacheable("utenti")
    public Optional<Utenti> getUserByUsername(String username) {
        return utentiRepository.findByUsername(username);
    }

    @Override
    //@Transactional
    @Cacheable("utenti")
    public void salvaUtente(Utenti utente) {
        utentiRepository.save(utente);
    }

    @Override
    @CachePut(value = "utenti", key = "#utente.id")
    public void aggiornaUtente(Integer id,Utenti utente) {
        utentiRepository.save(utente);

    }

    @Override
    @CacheEvict(value = "utenti",key ="#id")
    public void eliminaUtente(Integer id) {
        utentiRepository.deleteById(id);
    }


}

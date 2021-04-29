package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.entities.Utenti;

import java.util.List;
import java.util.Optional;

public interface UtentiService {

    List<Utenti> getAllUsers();

    Optional<Utenti> getUserById(Integer id);

    Optional<Utenti> getUserByUsername(String username);

    void salvaUtente(Utenti utente);

    void aggiornaUtente(Integer id,Utenti utente);

    void eliminaUtente(Integer id);
}

package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.entities.Utenti;

import java.util.List;
import java.util.Optional;

public interface UtentiService {

    public List<Utenti> getAllUsers();

    public Optional<Utenti> getUserById(Integer id);

    public Optional<Utenti> getUserByUsername(String username);
}

package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Utenti;

import java.util.List;
import java.util.Optional;

public interface UtentiService {

    public List<Utenti> getAllUsers();

    public Optional<Utenti> getUserById(Integer id);
}

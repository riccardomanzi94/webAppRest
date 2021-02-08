package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Utenti;

import java.util.List;

public interface UtentiService {

    public List<Utenti> getAllUsers();

    public Utenti getUserById(Integer id);
}

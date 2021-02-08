package it.riccardo.app.webapprest.service;

import it.riccardo.app.webapprest.model.Utenti;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UtentiService {

    public List<Utenti> getAllUsers();
}

package it.riccardo.app.webapprest.repository;

import it.riccardo.app.webapprest.model.entities.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti,Integer> {

    Optional<Utenti> findByUsername(String username);
}

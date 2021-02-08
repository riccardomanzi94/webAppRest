package it.riccardo.app.webapprest.repository;

import it.riccardo.app.webapprest.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepository extends JpaRepository<Utenti,Integer> {
}

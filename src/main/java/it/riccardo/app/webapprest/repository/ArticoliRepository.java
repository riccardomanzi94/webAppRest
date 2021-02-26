package it.riccardo.app.webapprest.repository;

import it.riccardo.app.webapprest.model.entities.Articoli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoliRepository extends JpaRepository<Articoli,String> {
}

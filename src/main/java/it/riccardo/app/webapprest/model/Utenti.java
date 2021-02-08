package it.riccardo.app.webapprest.model;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Entity
@Table(name = "utenti")
@Data
public class Utenti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

}

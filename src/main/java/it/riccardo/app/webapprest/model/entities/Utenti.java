package it.riccardo.app.webapprest.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@ApiModel(description = "Utenti")
public class Utenti implements Serializable {

    private static final long serialVersionUID = -1767984579021055754L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(value = "Id")
    private Integer id;

    @Column(name = "nome")
    @ApiModelProperty(value = "nome dell'utente")
    private String nome;

    @Column(name = "cognome")
    @ApiModelProperty(value = "cognome dell'utente")
    private String cognome;

    @Column(name = "email")
    @ApiModelProperty(value = "email")
    private String email;

    @Column(name = "username")
    @ApiModelProperty(value = "username")
    private String username;

    @ToString.Exclude
    @Column(name = "password")
    @ApiModelProperty(value = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
    @JsonManagedReference
    private Set<Articoli> articoli = new HashSet<>();

}

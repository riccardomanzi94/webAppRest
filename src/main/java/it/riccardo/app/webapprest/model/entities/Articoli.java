package it.riccardo.app.webapprest.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "articoli")
@Data
public class Articoli implements Serializable {

    private static final long serialVersionUID = -8249681397686842988L;

    @Id
    @Column(name = "CODART")
    private String codArt;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Column(name = "UM")
    private String um;

    @Column(name = "CODSTAT")
    private String codStat;

    @Column(name = "PZCART")
    private Integer pzCart;

    @Column(name = "PESONETTO")
    private double pesoNetto;

    @Column(name = "IDSTATOART")
    private String idStatoArt;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATACREAZIONE")
    private Date dataCreaz;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDUSER",referencedColumnName = "id")
    @JsonBackReference
    private Utenti user;
}

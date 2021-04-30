package it.riccardo.app.webapprest.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "articoli")
@Data
@ApiModel(description = "Articoli")
public class Articoli implements Serializable {

    private static final long serialVersionUID = -8249681397686842988L;

    @Id
    @Column(name = "CODART")
    @ApiModelProperty(value = "codice articolo")
    private String codArt;

    @Column(name = "DESCRIZIONE")
    @ApiModelProperty(value = "descrizione")
    private String descrizione;

    @Column(name = "UM")
    @ApiModelProperty(value = "unità di misura")
    private String um;

    @Column(name = "CODSTAT")
    @ApiModelProperty(value = "codice statistico")
    private String codStat;

    @Column(name = "PZCART")
    @ApiModelProperty(value = "pezzi per articolo")
    private Integer pzCart;

    @Column(name = "PESONETTO")
    @ApiModelProperty(value = "pesonetto")
    private double pesoNetto;

    @Column(name = "IDSTATOART")
    @ApiModelProperty(value = "stato articolo")
    private String idStatoArt;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATACREAZIONE")
    @ApiModelProperty(value = "data creazione")
    private Date dataCreaz;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "IDUSER",referencedColumnName = "id")
    @JsonBackReference
    private Utenti user;
}

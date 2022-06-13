package org.enspy.GestionParcInfo.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "materiels")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Materiel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String nom;


    private String description;

    private String nomFabricant;

    private int dureevieestimee;

    private String dateachat;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "materiel_logiciel",
            joinColumns = {@JoinColumn(name = "MATERIEL_ID", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name="LOGICIEL_ID", referencedColumnName = "Id")})
    private List<Logiciel> logiciels;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "materiel_panne",
            joinColumns = {@JoinColumn(name = "MATERIEL_ID", referencedColumnName = "Id")},
            inverseJoinColumns = {@JoinColumn(name="PANNE_ID", referencedColumnName = "Id")})
    private List<Panne> pannes;

    @ManyToOne
    @JoinColumn(name = "bureau_id")
    private Bureau bureau;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;


}

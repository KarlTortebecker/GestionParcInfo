package org.enspy.GestionParcInfo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name="pannes")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Panne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String type;

    private String materielaffecte;

    private String description;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToMany
    @JoinTable(name="materiel-panne",
            joinColumns = {@JoinColumn(name="PANNE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="MATERIEL_ID", referencedColumnName = "ID")})
    private List<Materiel> materiels;



}

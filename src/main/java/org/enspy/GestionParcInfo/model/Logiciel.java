package org.enspy.GestionParcInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "logiciels")
@NoArgsConstructor
@AllArgsConstructor
public class Logiciel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate prochainemaj;
    private String nomFabricant;
    private String description;

    @ManyToMany
    @JoinTable(name="materiel-logiciel",
            joinColumns = {@JoinColumn(name="LOGICIEL_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="MATERIEL_ID", referencedColumnName = "ID")})
    private List<Materiel> materiels;


}


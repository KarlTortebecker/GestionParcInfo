package org.enspy.GestionParcInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_id")
    private int id;
    private String nom;

    @OneToMany(mappedBy="categorie")
    private List<Materiel> materiels;



}

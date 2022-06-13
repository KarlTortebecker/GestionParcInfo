package org.enspy.GestionParcInfo.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="bureaux")
@AllArgsConstructor
@NoArgsConstructor
public class Bureau {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty
        @Column(nullable = false)
        private String nom;
        private String nomDepartement;

        @OneToMany(mappedBy="bureau")
        private List<Materiel> materiels;

        @OneToMany(mappedBy="bureau")
        private List<User> users;



    }


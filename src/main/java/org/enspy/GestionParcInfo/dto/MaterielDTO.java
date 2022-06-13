package org.enspy.GestionParcInfo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MaterielDTO {

    private Long id;
    private String nomFabricant;
    private String nom;
    private String description;
    private int dureevieestimee;
    private String dateachat;
    private int bureauId;
    private int categorieId;
}

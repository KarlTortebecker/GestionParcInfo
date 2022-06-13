package org.enspy.GestionParcInfo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MaterielDTO {

    private Long id;
    private String nomFabricant;
    private int dureevieestimee;
    private LocalDate dateachat;
    private Long bureauId;
    private Long categorieId;
}

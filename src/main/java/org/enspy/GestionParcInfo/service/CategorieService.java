package org.enspy.GestionParcInfo.service;

import org.enspy.GestionParcInfo.model.Categorie;
import org.enspy.GestionParcInfo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie(){
        return categorieRepository.findAll();
    }
}

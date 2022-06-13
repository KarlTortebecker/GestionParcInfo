package org.enspy.GestionParcInfo.service;

import org.enspy.GestionParcInfo.model.Materiel;
import org.enspy.GestionParcInfo.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService {
    @Autowired
    MaterielRepository materielRepository;

    public List<Materiel> getAllMateriel(){
        return materielRepository.findAll();
    }
    public void addMateriel(Materiel materiel){
        materielRepository.save(materiel);
    }
}

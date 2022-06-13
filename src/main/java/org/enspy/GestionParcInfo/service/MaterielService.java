package org.enspy.GestionParcInfo.service;

import org.enspy.GestionParcInfo.model.Materiel;
import org.enspy.GestionParcInfo.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void removeMaterielById(Long id){
        materielRepository.deleteById(id);
    }
    public Optional<Materiel> getMaterielById(Long id){
        return materielRepository.findById(id);
    }

}

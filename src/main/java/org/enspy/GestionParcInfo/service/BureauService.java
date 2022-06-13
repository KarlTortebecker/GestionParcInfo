package org.enspy.GestionParcInfo.service;

import org.enspy.GestionParcInfo.model.Bureau;
import org.enspy.GestionParcInfo.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BureauService {
    @Autowired
    BureauRepository bureauRepository;

    public List<Bureau> getAllBureau(){
        return bureauRepository.findAll();
    }
    public void addBureau(Bureau bureau){
        bureauRepository.save(bureau);
    }
}

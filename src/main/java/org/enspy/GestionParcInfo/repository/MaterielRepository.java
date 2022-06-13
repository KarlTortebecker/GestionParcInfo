package org.enspy.GestionParcInfo.repository;

import org.enspy.GestionParcInfo.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

}

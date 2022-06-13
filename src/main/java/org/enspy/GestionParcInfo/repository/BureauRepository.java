package org.enspy.GestionParcInfo.repository;

import org.enspy.GestionParcInfo.model.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BureauRepository extends JpaRepository<Bureau, Long> {
}

package org.enspy.GestionParcInfo.repository;

import org.enspy.GestionParcInfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

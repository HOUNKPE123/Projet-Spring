package com.davProject.RAD_PROJECT.repository;

import com.davProject.RAD_PROJECT.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Integer> {

}

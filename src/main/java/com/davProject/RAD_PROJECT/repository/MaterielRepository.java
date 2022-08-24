package com.davProject.RAD_PROJECT.repository;


import com.davProject.RAD_PROJECT.entity.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Integer> {
}

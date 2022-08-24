package com.davProject.RAD_PROJECT.repository;

import com.davProject.RAD_PROJECT.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Modifying
    @Transactional
    @Query("update Reservation a set a.prixTotal=a.prixTotal + :prix where a.id= :idd") //requete personnaliser
    void updatePrixTotal(@Param("idd") int idd, @Param("prix") float prix);
}

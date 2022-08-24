package com.davProject.RAD_PROJECT.service;

import com.davProject.RAD_PROJECT.entity.Reservation;
import com.davProject.RAD_PROJECT.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<Reservation> listReservation(){
        return reservationRepository.findAll();
    }

    public Reservation showOneReservation(int id){
        return reservationRepository.findById(id).get();
    }

    public void deleteOneReservation(int id){
        reservationRepository.deleteById(id);
    }

    public void updatePrixTotal(int id,float prix){
        reservationRepository.updatePrixTotal(id,prix);
    }
}

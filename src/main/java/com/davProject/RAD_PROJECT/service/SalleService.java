package com.davProject.RAD_PROJECT.service;

import com.davProject.RAD_PROJECT.entity.Reservation;
import com.davProject.RAD_PROJECT.entity.Salle;
import com.davProject.RAD_PROJECT.repository.ReservationRepository;
import com.davProject.RAD_PROJECT.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;

@Service
public class SalleService {
    @Autowired
    SalleRepository salleRepository;
    public List<Salle> listeSalle(){
        return salleRepository.findAll();
    }

    public Salle showOneSalle(int id){
        return salleRepository.findById(id).get();
    }
}

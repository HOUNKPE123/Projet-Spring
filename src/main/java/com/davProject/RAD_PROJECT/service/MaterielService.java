package com.davProject.RAD_PROJECT.service;

import com.davProject.RAD_PROJECT.entity.Materiel;
import com.davProject.RAD_PROJECT.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService {
    @Autowired
    private MaterielRepository materielRepository;

    public void saveMateriel(Materiel materiel){
        materielRepository.save(materiel);
    }

    public List<Materiel> listMateriel(){
        return materielRepository.findAll();
    }

    public Materiel showOneMateriel(int id){
        return materielRepository.findById(id).get();
    }

    public void deleteOneMateriel(int id){
        materielRepository.deleteById(id);
    }
}

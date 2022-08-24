package com.davProject.RAD_PROJECT.controller;

import com.davProject.RAD_PROJECT.entity.Materiel;
import com.davProject.RAD_PROJECT.service.MaterielService;
import com.davProject.RAD_PROJECT.service.ReservationService;
import com.davProject.RAD_PROJECT.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class clientController {
    @Autowired
    SalleService salleService;
    @Autowired
    MaterielService materielService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("/client/afficher")
    public String afficherSalle(Model model){
        model.addAttribute("listeSalle",salleService.listeSalle());
        return "client/listeClasse";
    }

    @GetMapping("/salle/materiel")
    public String afficherMateriel(Model model){
        model.addAttribute("listeMateriel",materielService.listMateriel());
        return "/client/listeMateriel";
    }

    @GetMapping("/client/ajoutMateriel/{id}")
    public String ajoutMateriel(@PathVariable("id")int id, Model model){
        model.addAttribute("listeMateriel",materielService.listMateriel());
        model.addAttribute("uneReservation",reservationService.showOneReservation(id));
        return "client/formulaireAjoutMateriel";
    }

    @PostMapping("/ajoutMateriel/save")
    public String saveAjout(@ModelAttribute("materiel")Materiel materiel){
        materielService.saveMateriel(materiel);
        reservationService.updatePrixTotal(materiel.getReservationId(),materiel.getPrix());
        return "redirect:/reservationClient/afficher";
    }
}

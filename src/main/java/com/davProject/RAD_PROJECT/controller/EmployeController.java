package com.davProject.RAD_PROJECT.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.davProject.RAD_PROJECT.entity.Reservation;
import com.davProject.RAD_PROJECT.entity.Salle;
import com.davProject.RAD_PROJECT.entity.Users;
import com.davProject.RAD_PROJECT.service.MaterielService;
import com.davProject.RAD_PROJECT.service.ReservationService;
import com.davProject.RAD_PROJECT.service.SalleService;
import com.davProject.RAD_PROJECT.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class EmployeController {
    @Autowired
    private SecurityUserDetailsService userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    ReservationService reservationService;
    @Autowired
    SalleService salleService;
    @Autowired
    MaterielService materielService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(Users users) {
        userDetailsManager.createUser(users);
        return "redirect:/login";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }

    /*@GetMapping("/")
    public String ShowReservation(Model model){
        model.addAttribute("listeReservation",reservationService.listReservation());

        return "/reservation/listeReservation";
    }*/

    @GetMapping("/reservation/afficher")
    public String ShowReservation2(Model model){
        model.addAttribute("listeReservation",reservationService.listReservation());
        return "/reservation/listeReservation";
    }

    @GetMapping("/reservationClient/afficher")
    public String ShowReservation3(Model model){
        model.addAttribute("listeReservation",reservationService.listReservation());
        return "/client/listeReservationClient";
    }


    @GetMapping("/formulaire")
    public String ShowReservationFormulaire(Model model){
        model.addAttribute("listeSalle",salleService.listeSalle());
        return "/reservation/formulaireReservation";
    }


    @PostMapping("/reservation/save")
    public String ajouterReservation(Reservation reservation){
        reservationService.saveReservation(reservation);
        return "redirect:/reservationClient/afficher";
    }

    @GetMapping("/reservation/update/{id}")
    public String formUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("UneReservation",reservationService.showOneReservation(id));
        model.addAttribute("listeSalle",salleService.listeSalle());
        return "/reservation/reservationUpdate";
    }

    @PostMapping("/reservation/update")
    public String saveUpdate(@ModelAttribute("reservation") Reservation reservation){
        reservationService.saveReservation(reservation);
        return "redirect:/reservationClient/afficher";
    }

    @GetMapping("reservation/delete/{id}")
    public String deleteReservation(@PathVariable("id") int id){
        reservationService.deleteOneReservation(id);
        return "redirect:/reservationClient/afficher";
    }

//My Dashboard Controller
    @RequestMapping("/dash")
    public String dashFonction(Model model){
        model.addAttribute("listeReservation",reservationService.listReservation());
        return "/dashboard";
    }

    @RequestMapping("/dashClient")
    public String dashFonction2(Model model){
        model.addAttribute("listeSalle",salleService.listeSalle());
        return "/dashboardClient";
    }
}
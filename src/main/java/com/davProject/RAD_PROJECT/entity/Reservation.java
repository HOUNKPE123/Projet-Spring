package com.davProject.RAD_PROJECT.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private String nomManifestation;
    private int nbrPerso;
    private String nomClient;
    private String adressClient;
    private float prixTotal;
    @ManyToOne
    @JoinColumn(name = "salleId",insertable = false,updatable = false)
    private Salle salle;
    private int salleId;
}

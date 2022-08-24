package com.davProject.RAD_PROJECT.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;
    private float surface;
    private int capMax;
    private int capMin;
    private float prixReservation;
    @OneToMany
    @JoinColumn(name = "materielId",insertable = false,updatable = false)
    private List<Materiel> materiel;
    private int materielId;
    private Boolean payant;
    private Boolean gardient;

}

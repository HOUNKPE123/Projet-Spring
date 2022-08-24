package com.davProject.RAD_PROJECT.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private float prix;
    @ManyToOne
    @JoinColumn(name = "reservationId",insertable = false,updatable = false)
    private Reservation reservation;
    private int reservationId;
}

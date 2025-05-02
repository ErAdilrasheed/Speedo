package com.speedo.speedo.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;

    @Column(unique = true, nullable = false)
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;
}

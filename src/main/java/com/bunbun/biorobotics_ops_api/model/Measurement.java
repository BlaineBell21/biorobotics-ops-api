package com.bunbun.biorobotics_ops_api.model;

import jakarta.persistence.*;


@Table(name = "measurement")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private int measurementId;
}

package com.bunbun.biorobotics_ops_api.user;

import jakarta.persistence.*;


@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
}

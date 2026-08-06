package com.bunbun.biorobotics_ops_api.report;

import jakarta.persistence.*;


@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int reportId;
}

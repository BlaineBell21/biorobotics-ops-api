package com.bunbun.biorobotics_ops_api.model;

import jakarta.persistence.*;


@Table(name = "workflow")
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workflow_id")
    private int workflowId;
}

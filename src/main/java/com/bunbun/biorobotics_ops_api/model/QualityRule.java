package com.bunbun.biorobotics_ops_api.model;

import jakarta.persistence.*;


@Table(name = "quality_rule")
public class QualityRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quality_rule_id")
    private int qualityRuleId;
}

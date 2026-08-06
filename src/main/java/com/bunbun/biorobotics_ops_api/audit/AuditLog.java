package com.bunbun.biorobotics_ops_api.audit;

import jakarta.persistence.*;


@Table(name = "audit_log")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="audit_id")
    private int auditId;
}

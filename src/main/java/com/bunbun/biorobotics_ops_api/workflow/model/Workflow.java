package com.bunbun.biorobotics_ops_api.workflow.model;

import com.bunbun.biorobotics_ops_api.workflow.model.enums.WorkflowStatus;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "workflow")
public class Workflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workflow_id")
    private Long workflowId;

    @Column(name = "workflow_code", nullable = false, unique = true, length = 50)
    private String workflowCode;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String version;

    @Column(name = "workflow_status", nullable = false, length = 30)
    private WorkflowStatus status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public Workflow() {
    }

    public Workflow(String workflowCode, String name, String description, String version, WorkflowStatus status, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.workflowCode = workflowCode;
        this.name = name;
        this.description = description;
        this.version = version;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

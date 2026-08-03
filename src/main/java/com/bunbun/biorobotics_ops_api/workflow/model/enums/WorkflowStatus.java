package com.bunbun.biorobotics_ops_api.workflow.model.enums;

public enum WorkflowStatus {
    DRAFT("Draft"),
    SHEDULED("Scheduled"),
    IN_PROGRESS("In Progress"),
    ON_HOLD("On Hold"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    FAILED("Failed");

    WorkflowStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private String label;

}

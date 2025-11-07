package com.teammanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String status;
    private String assignedTo;

    public Task() {}

    public Task(String title, String status, String assignedTo) {
        this.title = title;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public String getAssignedTo() { return assignedTo; }

    public void setTitle(String title) { this.title = title; }
    public void setStatus(String status) { this.status = status; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
}

package com.householdos.householdos.entity;

import com.householdos.householdos.enums.MaintenanceStatus;
import com.householdos.householdos.enums.MaintenanceType;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private MaintenanceType type;

    @Enumerated(EnumType.STRING)
    private MaintenanceStatus status;

    private LocalDateTime createdDate;

    private LocalDate dueDate;

    private LocalDate completedDate;

    private boolean deleted = false;

    public Maintenance(String title, MaintenanceType type, MaintenanceStatus status, LocalDateTime createdDate, LocalDate dueDate, LocalDate completedDate,boolean deleted) {
        this.title = title;
        this.type = type;
        this.status = status;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.deleted = deleted;
    }

    public Maintenance() {
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MaintenanceType getType() {
        return type;
    }

    public void setType(MaintenanceType type) {
        this.type = type;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }
}

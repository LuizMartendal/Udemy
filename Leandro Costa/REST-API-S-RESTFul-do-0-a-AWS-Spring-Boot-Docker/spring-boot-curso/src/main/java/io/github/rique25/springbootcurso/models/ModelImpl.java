package io.github.rique25.springbootcurso.models;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public abstract class ModelImpl implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String createdBy;
    private String updatedBy;
    private Date createdIn;
    private Date updatedIn;

    @PrePersist
    private void onCreate() {
        this.createdIn = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedIn = new Date();
    }

    public ModelImpl(UUID id, String createdBy, String updatedBy, Date createdIn, Date updatedIn) {
        this.id = id;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdIn = createdIn;
        this.updatedIn = updatedIn;
    }

    public ModelImpl() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Date createdIn) {
        this.createdIn = createdIn;
    }

    public Date getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Date updatedIn) {
        this.updatedIn = updatedIn;
    }
}

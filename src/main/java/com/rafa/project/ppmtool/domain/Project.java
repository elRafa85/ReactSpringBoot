package com.rafa.project.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String projectName;
    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 chars")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Description is mandatory :)")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    private Date end_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date crated_on;
    private Date updated_on;

    @PrePersist
    private void onCreate(){
        this.crated_on = new Date();
    }

    @PreUpdate
    private void onUpdate(){
        this.updated_on = new Date();
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCrated_on() {
        return crated_on;
    }

    public void setCrated_on(Date crated_on) {
        this.crated_on = crated_on;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }
}

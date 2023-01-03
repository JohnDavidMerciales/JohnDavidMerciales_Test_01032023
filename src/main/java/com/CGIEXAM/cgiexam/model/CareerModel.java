package com.CGIEXAM.cgiexam.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "career_table")
public class CareerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String description;

    String targetDate;

    String completedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CareerModel that = (CareerModel) obj;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects
                .equals(description, that.description) && Objects.equals(targetDate, that.targetDate)
                && Objects.equals(completedDate, that.completedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, targetDate, completedDate);
    }

    @Override
    public String toString() {
        return "CareerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", completeDate='" + completedDate + '\'' +
                '}';
    }
}

package ru.afanaseva.jdbc.experiment.entity;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
public enum CourseType {

    DESIGN,
    PROGRAMMING,
    MARKETING,
    BUSINESS,
    MANAGEMENT
}

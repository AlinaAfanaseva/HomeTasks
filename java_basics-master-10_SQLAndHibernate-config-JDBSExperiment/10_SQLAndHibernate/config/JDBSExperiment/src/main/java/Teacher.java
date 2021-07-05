package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;
import ru.afanaseva.jdbc.experiment.entity.Course;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    @Getter
    @Setter
    List<Course> courseList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private  int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int salary;

    @Getter
    @Setter
    private int age;

}

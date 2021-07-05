package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int duration;

    @Getter
    @Setter
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Getter
    @Setter
    private CourseType type;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @Getter
    @Setter
    private Teacher teacher;


    @Column(name = "students_count", nullable = true)
    @Getter
    @Setter
    private Integer studentsCount;

    @Getter
    @Setter
    private int price;

    @Column(name = "price_per_hour")
    @Getter
    @Setter
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @Getter
    @Setter
    private List<Student> students;


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public float getPricePerHour() {
//        return pricePerHour;
//    }
//
//    public void setPricePerHour(float pricePerHour) {
//        this.pricePerHour = pricePerHour;
//    }
//
//    public int getStudentsCount(){
//        return studentsCount;
//    }
//    public void setStudentsCount(int studentsCount){
//        this.studentsCount = studentsCount;
//    }
//
//    public void setType(CourseType type) {
//        this.type = type;
//    }
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//
//    public CourseType getType() {
//        return type;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

}

package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    @Getter
    @Setter
    private LinkedPurchaseListPK id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Course course;

    @Column(name = "student_name")
    @Getter
    @Setter
    private String student_name;

    @Column(name = "course_name")
    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private int price;

    @Column(name = "subscription_date")
    @Getter@Setter
    private Date subscriptionDate;

//    public LinkedPurchaseListPK getId() {
//        return id;
//    }
//
//    public void setId(LinkedPurchaseListPK id) {
//        this.id = id;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    public String getStudent_name() {
//        return student_name;
//    }
//
//    public void setStudent_name(String student_name) {
//        this.student_name = student_name;
//    }
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
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
//    public Date getSubscriptionDate() {
//        return subscriptionDate;
//    }
//
//    public void setSubscriptionDate(Date subscriptionDate) {
//        this.subscriptionDate = subscriptionDate;
//    }
}

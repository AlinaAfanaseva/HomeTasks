package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Formatter;


@Value
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "purchaseList")
public class PurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

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
    private String studentName;

    @Column(name = "course_name")
    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private int price;

    @Column(name = "subscription_date")
    @Getter
    @Setter
    private Date subscriptionDate;

    @Override
    public String toString(){
        return new Formatter().format("PurchaseList (studentName: %s, courseName: %s, subscriptionDate: %3$td.%3tm.%3$tY",
                studentName, courseName, subscriptionDate).toString();
    }

//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
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

}

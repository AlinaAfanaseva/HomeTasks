package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PurchaseListPK implements Serializable {

    @Column(name = "student_name")
    @Getter
    @Setter
    String studentName;

    @Column(name = "course_name")
    @Getter
    @Setter
    String courseName;

    @SuppressWarnings("unused")
    PurchaseListPK(){

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
}

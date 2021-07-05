package ru.afanaseva.jdbc.experiment.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class LinkedPurchaseListPK implements Serializable {

    @Column(name = "student_id")
    @Getter
    @Setter
    int studentId;

    @Column(name = "course_id")
    @Getter
    @Setter
    int courseId;

    @SuppressWarnings("unused")
    LinkedPurchaseListPK() {}

//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
}

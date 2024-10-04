package com.UST.CompositeKey.entity;

import com.UST.CompositeKey.StudentCourseId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(StudentCourseId.class)
public class StudentCourse {
    @Id
    private long studentId;
    @Id
    private long courseId;

    public StudentCourse(String grade, long courseId, long studentId) {
        this.grade = grade;
        this.courseId = courseId;
        this.studentId = studentId;
    }
    public StudentCourse() {}

    private String grade;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }




}

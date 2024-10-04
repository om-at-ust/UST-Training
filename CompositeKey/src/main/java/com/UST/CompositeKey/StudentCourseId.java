package com.UST.CompositeKey;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentCourseId implements Serializable {
    private long studentId;

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    private long courseId;
    public long getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseId that = (StudentCourseId) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    StudentCourseId(){};
    public StudentCourseId(long studentId, long courseId){
        this.studentId=studentId;
        this.courseId=courseId;
    }
}

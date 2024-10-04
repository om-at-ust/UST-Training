package com.UST.CompositeKey.repository;

import com.UST.CompositeKey.StudentCourseId;
import com.UST.CompositeKey.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,StudentCourseId> {
}

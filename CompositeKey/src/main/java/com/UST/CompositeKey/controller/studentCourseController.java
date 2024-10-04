package com.UST.CompositeKey.controller;

import com.UST.CompositeKey.StudentCourseId;
import com.UST.CompositeKey.entity.StudentCourse;
import com.UST.CompositeKey.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class studentCourseController {
    @Autowired
    private StudentCourseRepository studentCourseRepository;


    @GetMapping("/getAll")
    public List<StudentCourse> student(){
        return studentCourseRepository.findAll();

    }
    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";

    }
    @PutMapping("/saveCourse")
    public ResponseEntity<?> saveCourse(@RequestBody StudentCourse course){
        try {
            studentCourseRepository.save(course);
            return new ResponseEntity<>("Course saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/id/{studentId}/{courseId}")
    public ResponseEntity<?> getCourseByIds(@PathVariable long studentId, @PathVariable long courseId){
        StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId);
        Optional<StudentCourse> course  = studentCourseRepository.findById(studentCourseId);
        if(course.isPresent()){
            return new ResponseEntity<>(course.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);

    }


}

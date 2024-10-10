package com.UST.Learning.Security.controller;


import com.UST.Learning.Security.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SecurtiyController {

    @GetMapping()
    public String home(HttpServletRequest request) {
        return "your sessionId is: " + request.getSession().getId();
    }

    List<Student> studentList = new ArrayList<>(List.of(
            new Student("John", 22, "Computer Science"),
            new Student("Jane", 23, "Mathematics"),
            new Student("Bob", 24, "English Literature")
    ));

    @GetMapping("/getAllstudents")
    public List<Student> getStudents() {
        return studentList;
    }

    // apart from get request all other request X-CSRF-TOKEN in the headers
    // otherwise it won't work
    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) {


        studentList.add(student);
        return student.getName() + "added to studentList successfully";
    }
    @GetMapping("/getToken")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentList.removeIf(student -> student.getId() == id);
        return "Student with id " + id + " has been removed";
    }
}

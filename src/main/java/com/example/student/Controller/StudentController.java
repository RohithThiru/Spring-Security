package com.example.student.Controller;


import com.example.student.Model.Students;
import com.example.student.Services.StudentsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity<List<Students>> getAllStudents(){
        List<Students> students = studentsService.getStudents();
        return new ResponseEntity<List<Students>>(students, HttpStatus.OK);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public ResponseEntity<String> saveStudents(@RequestBody Students students){
        studentsService.addStudent(students);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }


}

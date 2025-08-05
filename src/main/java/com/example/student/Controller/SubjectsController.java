package com.example.student.Controller;

import com.example.student.Model.Subjects;
import com.example.student.Services.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectsController {

    @Autowired
    SubjectsService subjectsService;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subjects>> getSubjects(){
        List<Subjects> subjects = subjectsService.getSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subjects> addSubjects(@RequestBody Subjects subjects){
        subjectsService.addSubjects(subjects);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}

package com.example.student.Services;


import com.example.student.Model.Subjects;
import com.example.student.Repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {

    @Autowired
    public SubjectsRepository subjectsRepository;

    public List<Subjects> getSubjects() {
        List<Subjects> subjects = (List<Subjects>) subjectsRepository.findAll();
        return subjects;
    }

    public Subjects addSubjects(Subjects subjects) {
        subjectsRepository.save(subjects);
        return subjects;
    }


}

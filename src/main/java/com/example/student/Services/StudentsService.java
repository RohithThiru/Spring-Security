package com.example.student.Services;

import com.example.student.Model.Students;
import com.example.student.Model.UserPrincipal;
import com.example.student.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentsService implements UserDetailsService {

    @Autowired
    public StudentsRepository repo;

    public List<Students> getStudents(){
        List<Students> studentsList = repo.findAll();
        return studentsList;
    }

    public void addStudent(Students student) {
        repo.save(student);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Students student = repo.findByname(name);
        if (student == null) {
            throw new UsernameNotFoundException(name);
        }
        return new UserPrincipal(student);
    }
}

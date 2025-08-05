package com.example.student.Repository;

import com.example.student.Model.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {
}

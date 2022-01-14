package com.example.demo.student;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;

	public List<Student> getAllStudents() {
	    List<Student> students = new ArrayList<>();
	    
	    studentRepo.findAll()
	    .forEach(students::add);

	    return students;
	}

	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public Optional<Student> getStudent(String id) {
	     return studentRepo.findById(id);
	}
	
	public void updateStudent(String id, Student student) {
	     studentRepo.save(student);
	}
	
	public void deleteStudent(String id) {
	     studentRepo.deleteById(id);
	}

	
}

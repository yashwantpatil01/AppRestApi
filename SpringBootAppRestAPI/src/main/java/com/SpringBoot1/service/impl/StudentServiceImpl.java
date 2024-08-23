package com.SpringBoot1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot1.exception.ResoureNotFound;
import com.SpringBoot1.model.Student;
import com.SpringBoot1.repository.StudentRepository;
import com.SpringBoot1.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository repo;
	
	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Student saveStudent(Student std) {
		
		return repo.save(std);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
//		Optional<Student>  op=repo.findById(id);
//		if(op.isPresent()) {
//			return op.get();
//		}
//		else {
//			return new ResoureNotFound("Student", "ID", id);
//		}
		return repo.findById(id).
				orElseThrow( ()->new ResoureNotFound("Student", "ID", id));
	}

	@Override
	public Student updateStudentById(Student std, Long id) {
		Student existStudent=repo.findById(id).
				orElseThrow( () -> new ResoureNotFound("Student", "Id", id));
		existStudent.setFirstName(std.getFirstName());
		existStudent.setLastName(std.getLastName());
		existStudent.setEmail(std.getEmail());
		
		return repo.save(existStudent);
	}

	@Override
	public void deleteStudentById(Long id) {
		Student existingStudent=repo.findById(id).
				orElseThrow(() -> new ResoureNotFound("Student", "Id", id));
		
		repo.deleteById(id);
	}

}


/*
@Override
	public Employee updateEmployee(Employee emp, Long id) {
		//we need  check whether employee with given id is exist in DB or not
		Employee existEmp=emprepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		existEmp.setFirstName(emp.getFirstName());
		existEmp.setLastName(emp.getLastName());
		existEmp.setEmail(emp.getEmail());
		
		emprepo.save(existEmp);
		return existEmp;
	}


	@Override
	public void deleteEmployee(Long id) {
		//check whether a employee exist in DB or not
		emprepo.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		emprepo.deleteById(id);
	}

*/
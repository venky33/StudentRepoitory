package com.sms.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.repositiry.StudentRepository;
import com.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService  {

	@Autowired			//to take a reference of StudentRepository
	StudentRepository studentRepository;
	
	
	
	@Override
	public Student addStudent(Student s) {

		return studentRepository.save(s);
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	
	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(int id, Student student) {
		Student s=studentRepository.findById(id).get();
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		Student stud=studentRepository.save(s);
		return stud;
		
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student got deleted succesffully";
		
	}

	@Override
	public List<Student> getStudentByAddress(String address) {
		return studentRepository.findByAddress(address);
	}

	@Override
	public List<Student> getStudentsByNameAndAddress(String name, String address) {
		return studentRepository.findByNameAndAddress(name, address);

	}
}

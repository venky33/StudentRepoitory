package com.sms.service;

import java.util.List;

import com.sms.entity.Student;

public interface StudentService {
	Student addStudent(Student s);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	Student updateStudent(int id,Student student);
	String deleteStudent(int id);
	List<Student> getStudentByAddress(String address);
	List<Student> getStudentsByNameAndAddress(String name, String address);
}

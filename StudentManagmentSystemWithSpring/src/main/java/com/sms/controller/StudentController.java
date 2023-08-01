package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student;
import com.sms.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	/*
	@PostMapping("/createstudent")
	Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	......*/
	
	@PostMapping("/createstudent")
	ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
	}
	
	
	
	/*@GetMapping("/getstudents")
	List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
		
	}.....*/
	
	@GetMapping("/getstudents")
	ResponseEntity<List<Student>> getAllStudents()
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
		
	}
	
	
	/*@GetMapping("/getstudentById/{id}")
	Student getStudentById(@PathVariable int id)
	{
		return studentService.getStudentById(id);
	}*/
	

	@GetMapping("/getstudentById/{id}")
	ResponseEntity<Student> getStudentById(@PathVariable int id)
	{
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
	}
	
	
	/*@GetMapping("/updateStudentById/{id}")
	Student updateStudent(@PathVariable int id, @RequestBody  Student student)
	{
		
		return studentService.updateStudent( id,student);
		
	}*/
	
	@PutMapping("/updateStudentById/{id}")
	ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody  Student student)
	{
		
		return new ResponseEntity<Student>(studentService.updateStudent( id,student),HttpStatus.OK);
		
	}
	
	
	/*@DeleteMapping("/deleteStudent/{id}")
	String deleteStudentById(@PathVariable int id)
	{
		return studentService.deleteStudent(id);
	}*/
	
	@DeleteMapping("/deleteStudent/{id}")
	ResponseEntity<String> deleteStudentById(@PathVariable int id)
	{
		return new ResponseEntity<String>(studentService.deleteStudent(id),HttpStatus.OK);
	}
	
	/*@GetMapping("/getstudentByAddress/{address}")
		List<Student> getStudentsByAddress(@PathVariable String address)
		{
			return studentService.getStudentByAddress(address);
		}*/
	
	@GetMapping("/getstudentByAddress/{address}")
	List<Student> getStudentsByAddress(@PathVariable String address)
	{
		return studentService.getStudentByAddress(address);
	}
	
	@GetMapping("/getstudentByNameAndAddress/{name}/{address}")
	List<Student> getStudentsByNameAndAddress(@PathVariable String name, @PathVariable String address)
	{
		return studentService.getStudentsByNameAndAddress(name, address);
	}
	
	

}
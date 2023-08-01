package com.sms.repositiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	List<Student> findByAddress(String address);  //select * from where address = ?
	List<Student> findByNameAndAddress(String name, String Address);
}
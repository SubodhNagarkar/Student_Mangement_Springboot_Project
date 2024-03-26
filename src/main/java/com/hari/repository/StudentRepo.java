package com.hari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hari.model.Student;
import com.hari.model.StudentDTO;

public interface StudentRepo extends JpaRepository<Student, Integer>{


	public List<Student>findBymarks(Integer marks);
	
	public Student findByAddress(String address);
	
	@Query("select s.name from Student s where s.roll=?1")
	public String getStudentNameByRoll(Integer roll);
	
	@Query("select s.name,s.marks from Student s where s.address=?1")
	public List<String> getStudentNameAndMarksByAddress(String address);
	
	@Query("select new com.hari.model.StudentDTO(s.name , s.marks) from Student s where s.address=?1")
	public List<StudentDTO> getStudentNameAndMarksByAddress2(String address);
}

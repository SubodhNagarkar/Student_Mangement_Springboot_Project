package com.hari.service;

import java.util.List;

import com.hari.exception.StudentException;
import com.hari.model.Student;
import com.hari.model.StudentDTO;

public interface StudentService {

	public Student registerStudent(Student student);
	
	public Student getStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getallStudents() throws StudentException;
	
	public Student deleteStudentByRoll(Integer roll) throws StudentException;
	
	public Student updateStudentDetails(Student student) throws StudentException;
	
	public Student updateStudentMarks(Integer roll,Integer graceMarks) throws StudentException;

	public List<Student> getStudentsByMarks (Integer marks) throws StudentException;
	
	public Student getStudentByAddress (String address) throws StudentException;
	
	public String getStudentNAmeByRoll(Integer roll) throws StudentException;
	
	public List<String> getStudentNameAndMArksByAddress(String address) throws StudentException;
	
	public List<StudentDTO> getStudentNameAndMArksByAddress2(String address) throws StudentException;
}

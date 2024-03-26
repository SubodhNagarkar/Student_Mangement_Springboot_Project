package com.hari.service;


import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.exception.StudentException;
import com.hari.model.Student;
import com.hari.model.StudentDTO;
import com.hari.repository.StudentRepo;
@Service
public class Studentdaoimpl implements StudentService {
	@Autowired
	private StudentRepo sRepo;
	@Override
	public Student registerStudent(Student student) {
		Student savestudent =sRepo.save(student);
		return savestudent;
	}
	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {

		 java.util.Optional<Student> opt =sRepo.findById(roll);
		 if(opt.isPresent()) {
		 Student student = opt.get();
		return student;
		 }
		 else 
			 throw new StudentException("student not exist at roll "+roll);
	}
	@Override
	public List<Student> getallStudents() throws StudentException {
		List<Student> students = sRepo.findAll();
		if(students.size() == 0) {
			throw new StudentException("No students are there");
		}
		else
			return students;
	}
	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		java.util.Optional<Student> opt = sRepo.findById(roll);
		if(opt.isPresent()) {
			Student existingstudent = opt.get();
			sRepo.delete(existingstudent);
			
			return existingstudent;
		}
		else
			throw new StudentException("student doew noit exist with roll"+roll);
		
	}
	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		java.util.Optional<Student> opt= sRepo.findById(student.getRoll());
		
		if(opt.isPresent()) {
			Student updatedStudent = sRepo.save(student);
			return updatedStudent;
		}
		else
			throw new StudentException("Invalid Student Details");
	}
	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		Student existingstudent = sRepo.findById(roll).orElseThrow(() -> new StudentException("student does not exist at roll"+roll));
		
		existingstudent.setMarks(existingstudent.getMarks()+graceMarks);
		return sRepo.save(existingstudent);
	}
	@Override
	public List<Student> getStudentsByMarks(Integer marks) throws StudentException {
		List<Student> students = sRepo.findBymarks(marks);
		if(students.size()== 0) {
			throw new StudentException("No Student Found");
		}else
		{
			return students;
		}
	}
	@Override
	public Student getStudentByAddress(String address) throws StudentException {
		
	    Student student =	sRepo.findByAddress(address);
	    
	    if(student != null) {
	    	return student;
	    }
	    else {
	    	throw new StudentException("Student Not found at address "+address);
	    }
	}
	@Override
	public String getStudentNAmeByRoll(Integer roll) throws StudentException {
		
		String name = sRepo.getStudentNameByRoll(roll);
		
		if(name != null)
			return name;
		else
			throw new StudentException("Student not found at Roll "+roll);
	}
	@Override
	public List<String> getStudentNameAndMArksByAddress(String address) throws StudentException {
		
		List<String> results =sRepo.getStudentNameAndMarksByAddress(address);
		
		if(results.size()== 0) {
			throw new StudentException("no Student Details Found . . .");
		}
		else
		{
			return results;
		}
	}
	@Override
	public List<StudentDTO> getStudentNameAndMArksByAddress2(String address) throws StudentException {
		List<StudentDTO> results =sRepo.getStudentNameAndMarksByAddress2(address);
		
		if(results.size()==0)
			throw new StudentException("No StudentDetails Found");
		else
			return results;
	}

}

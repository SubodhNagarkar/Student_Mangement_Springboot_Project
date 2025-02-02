package com.hari.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hari.exception.StudentException;
import com.hari.model.Student;
import com.hari.model.StudentDTO;
import com.hari.service.StudentService;
@RestController
public class StudentController {
	@Autowired
	private StudentService sService;
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student){
		
		Student savedstudent =sService.registerStudent(student);
		
		return new ResponseEntity<Student>(savedstudent,HttpStatus.CREATED);
		
	}
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll")Integer roll) throws StudentException{
		
		Student student =sService.getStudentByRoll(roll);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler() throws StudentException{
		
		List<Student> students =sService.getallStudents();
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentVByRollHandler(@PathVariable ("roll")  Integer roll) throws StudentException {
		
		Student deletedStudent = sService.deleteStudentByRoll(roll);
		
		return new ResponseEntity<Student>(deletedStudent,HttpStatus.OK);
	}
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		Student updatedStudent =sService.updateStudentDetails(student);
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentHandlermarks(@PathVariable ("roll")  Integer roll, @RequestParam("gmarks") Integer gmarks) throws StudentException{
		Student updatedstudent =sService.updateStudentMarks(roll, gmarks);
		
		return new ResponseEntity<Student>(updatedstudent,HttpStatus.OK);
		
	}
	@GetMapping("/getstudents/{marks}")
	public ResponseEntity<List<Student>> getStudentByMarksHandler(@PathVariable ("marks")  Integer marks) throws StudentException{
		
		List<Student> students = sService.getStudentsByMarks(marks);
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@GetMapping("/getstudentbyaddress/{address}")
	public ResponseEntity<Student> getStudentByAddress( @PathVariable ("address") String address) throws StudentException{
		
	Student student = sService.getStudentByAddress(address);
	
	return new ResponseEntity<Student>(student,HttpStatus.OK); 
	}
	
	@GetMapping("/getName/{roll}")
	public ResponseEntity<String> getStudentNameByRoll(@PathVariable ("roll")  Integer roll) throws StudentException{
		String name = sService.getStudentNAmeByRoll(roll);
		
		return new ResponseEntity<String>(name,HttpStatus.OK);
	}
	
	@GetMapping("/getNameMarks/{address}")
	public ResponseEntity<List<String>> getStudentNameAndMarksByAddress(@PathVariable ("address") String address) throws StudentException{
		
		List<String> results= sService.getStudentNameAndMArksByAddress(address);
		
		return new ResponseEntity<List<String>>(results,HttpStatus.OK);
	}
	@GetMapping("/getNameMarksdto/{address}")
	public ResponseEntity<List<StudentDTO>> getStudentNameAndMarksAddressHandler2(@PathVariable ("address") String address) throws StudentException{
		
	List<StudentDTO> results =sService.getStudentNameAndMArksByAddress2(address);

	return new ResponseEntity<List<StudentDTO>>(results,HttpStatus.OK);
	}
	 
}

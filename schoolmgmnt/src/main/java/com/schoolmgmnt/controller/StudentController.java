package com.schoolmgmnt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmgmnt.dto.StudentDto;
import com.schoolmgmnt.dto.TeacherDto;
import com.schoolmgmnt.entity.Student;
import com.schoolmgmnt.entity.Teacher;
import com.schoolmgmnt.exceptionhandler.DataNotFoundException;
import com.schoolmgmnt.exceptionhandler.DataNotHandledException;
import com.schoolmgmnt.serviceimpl.StudentServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	@PostMapping("//addStudent")
	ResponseEntity<Student> addStudentRecord(@RequestBody @Valid  StudentDto studentDto){
		try
		{
			Student student = studentServiceImpl.addStudentRecord(studentDto);
			 if(student!=null) {
					return new ResponseEntity<Student>(student,HttpStatus.CREATED);
				}
		}
		catch(Exception ex)
		{
			throw new DataNotFoundException("Unable to handle Student Request");
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	//getting Student details by Its id
	
			@GetMapping(path="//getStudentById/{studentId}")
			public ResponseEntity<Student> getStudentDetailsById(@PathVariable("studentId") Long studentId)
			{
				return new ResponseEntity<Student>(studentServiceImpl.getStudentDetailsById(studentId),HttpStatus.OK);
//				try {
//					Student student = studentServiceImpl.getStudentDetailsById(studentId);
//					if(student!=null) {
//						return new ResponseEntity<Student>(student,HttpStatus.FOUND);
//					}
//				}
//				catch(Exception e)
//				{
//					throw new DataNotFoundException("No Such teacher with id " + studentId + " Found");
//				}
//				 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
				
			}
			//Getting student all studnet records
			
			@GetMapping(path="//students")
			public ResponseEntity<List<Student>> getAllStudents()
			{
				
				return new ResponseEntity<>(studentServiceImpl.displayAll(),HttpStatus.OK);
				 
			}
			
			//updating Student record based on id
			
			@PutMapping(path="//updateStudentRecords/{studentId}")
			public ResponseEntity<String> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody @Valid StudentDto studentDto)
			{
				try
				{
				 String student=studentServiceImpl.updateStudentRecord(studentId, studentDto);
				 if(student!=null)
					return new ResponseEntity<String>(student,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new DataNotHandledException("Unable to update student records");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);		
			}
			//deleting Student By its Id
			@DeleteMapping(path="//deleteRecordById/{studentId}")
			public ResponseEntity<String> deleteStudentRecord(@PathVariable("studentId") Long studentId)
			{
				try 
				{
				 String student=studentServiceImpl.deleteStudentRecordById(studentId);
				 if(student!=null)
					return new ResponseEntity<String>(student,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new DataNotFoundException("Unable to delete student records");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
			}
			//deleting all student records
				@DeleteMapping(path="/deleteAllStudentRecords")
				public ResponseEntity<String> deleteAllStudentRecord()
				{
					try
					{
					 String student=studentServiceImpl.deleteAllDStudents();
					 if(student!=null)
						return new ResponseEntity<String>(student,HttpStatus.ACCEPTED);
					}
					catch(Exception e)
					{
						throw new DataNotFoundException("Unable to delete student records");
					}
					return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
				}	
			
}

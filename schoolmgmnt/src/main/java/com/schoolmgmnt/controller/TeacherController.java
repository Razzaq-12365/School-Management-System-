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

import com.schoolmgmnt.dto.TeacherDto;
import com.schoolmgmnt.entity.Student;
import com.schoolmgmnt.entity.Teacher;
import com.schoolmgmnt.exceptionhandler.DataNotFoundException;
import com.schoolmgmnt.exceptionhandler.DataNotHandledException;
import com.schoolmgmnt.serviceimpl.TeacherServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeacherController {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;
	//For posting teacher records
		@PostMapping("/addTeacherRecord")
		public ResponseEntity<Teacher> addTeacherRecord(@RequestBody @Valid  TeacherDto teacherDto){
			try
			{
				Teacher teacher = teacherServiceImpl.addTeacherRecord(teacherDto);
				 if(teacher!=null) {
						return new ResponseEntity<Teacher>(teacher,HttpStatus.CREATED);
					}
			}
			catch(Exception ex)
			{
				throw new DataNotFoundException("Unable to handle Teacher Request");
			}
			return new ResponseEntity<Teacher>(HttpStatus.BAD_REQUEST);
		}
		//getting teacher details by Its id
		
		@GetMapping(path="/getTeacherById/{teacherId}")
		public ResponseEntity<Teacher> getTeacherDetailsById(@PathVariable("teacherId") Long teacherId)
		{
		return new ResponseEntity<Teacher>(teacherServiceImpl.getTeacherDetailsById(teacherId),HttpStatus.OK);

//		{
//			try {
//				Teacher teacher = teacherServiceImpl.getTeacherDetailsById(teacherId);
//				if(teacher!=null) {
//					return new ResponseEntity<Teacher>(teacher,HttpStatus.FOUND);
//				}
//			}
//			catch(Exception e)
//			{
//				throw new DataNotFoundException("No Such teacher with id " + teacherId + " Found");
//			}
//			 return new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
			
		}
		//Getting teacher all teacher records
		
		@GetMapping(path="/teachers")
		public ResponseEntity<List<Teacher>> getAllTeachers()
		{
			return new ResponseEntity<>(teacherServiceImpl.displayAll(),HttpStatus.OK);
//			try
//			{
//			 List<Teacher> teacherList=teacherServiceImpl.displayAll();
//			 if(teacherList!=null)
//				return new ResponseEntity<List<Teacher>>(teacherList,HttpStatus.FOUND);
//			}
//			catch(Exception e)
//			{
//				throw new DataNotFoundException("No Such Teacher Exist");
//			}
//			return new ResponseEntity<List<Teacher>>(HttpStatus.NOT_FOUND);
		}
		
		//updating Teacher record based on id
		
		@PutMapping(path="/updateTeacherRecords/{teacherId}")
		public ResponseEntity<String> updateTeacher(@PathVariable("teacherId") Long teacherId, @RequestBody @Valid TeacherDto teacherDto)
		{
			try
			{
			 String teacher=teacherServiceImpl.updateTeacherRecord(teacherId, teacherDto);
			 if(teacher!=null)
				return new ResponseEntity<String>(teacher,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new DataNotHandledException("Unable to update teacher records");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);		
		}
		//deleting Teacher By its Id
		@DeleteMapping(path="/deleteRecordById/{teacherId}")
		public ResponseEntity<String> deleteTeacherRecord(@PathVariable("teacherId") Long teacherId)
		{
			try 
			{
			 String teacher=teacherServiceImpl.deleteTeacherRecordById(teacherId);
			 if(teacher!=null)
				return new ResponseEntity<String>(teacher,HttpStatus.ACCEPTED);
			}
			catch(Exception e)
			{
				throw new DataNotFoundException("Unable to delete teacher records");
			}
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
		}
		//deleting all teacher records
			@DeleteMapping(path="/deleteAllTeacherRecords")
			public ResponseEntity<String> deleteAllTeacherRecord()
			{
				try
				{
				 String teacher=teacherServiceImpl.deleteAllTeacherRecords();
				 if(teacher!=null)
					return new ResponseEntity<String>(teacher,HttpStatus.ACCEPTED);
				}
				catch(Exception e)
				{
					throw new DataNotFoundException("Unable to delete teacher records");
				}
				return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);		
			}	
		
}

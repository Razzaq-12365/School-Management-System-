package com.schoolmgmnt.service;

import java.util.List;

import com.schoolmgmnt.dto.StudentDto;
import com.schoolmgmnt.entity.Student;

public interface StudentService {
	public Student addStudentRecord(StudentDto studentDto);
	public Student getStudentDetailsById(Long studentId);
	public List<Student> displayAll();
	public String updateStudentRecord(Long studentId, StudentDto params);
	public String deleteStudentRecordById(Long studentId);
	public String deleteAllDStudents();

}

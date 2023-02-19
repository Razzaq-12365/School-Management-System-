package com.schoolmgmnt.serviceimpl;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgmnt.dto.StudentDto;
import com.schoolmgmnt.entity.Student;
import com.schoolmgmnt.repositories.StudentRepository;
import com.schoolmgmnt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudentRecord(StudentDto studentDto) {
		Student student = Student.builder()
					.studentId(studentDto.getStudentId())
					.studentName(studentDto.getStudentName())
					.email(studentDto.getEmail())
					.address(studentDto.getAddress())
					.build();
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentDetailsById(Long studentId) {
		
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> displayAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public String updateStudentRecord(Long studentId, StudentDto params) {
		Student student;
		student = studentRepository.findById(studentId).get();
		student.setStudentName(params.getStudentName());
		student.setEmail(params.getEmail());
		student.setAddress(params.getAddress());
		studentRepository.save(student);
		return "student records Updated Successfully";

	}

	@Override
	public String deleteStudentRecordById(Long studentId) {
		studentRepository.deleteById(studentId);
		return "Doctor Record With Id " + studentId + " is deleted siccessfully";
	}

	@Override
	public String deleteAllDStudents() {
		studentRepository.deleteAll();
		return "All student Records Deleted successfully";
	}

}

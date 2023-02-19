package com.schoolmgmnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgmnt.dto.TeacherDto;
import com.schoolmgmnt.entity.Teacher;
import com.schoolmgmnt.repositories.TeacherRepository;
import com.schoolmgmnt.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Teacher addTeacherRecord(TeacherDto teacherDto) {
		Teacher teacher = Teacher.builder()
					.teacherId(teacherDto.getTeacherId())
					.teacherName(teacherDto.getTeacherName())
					.contactNumber(teacherDto.getContactNumber())
					.email(teacherDto.getEmail())
//					.students(teacherDto.getStudents())
					.build();
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacherDetailsById(Long teacherId) {
		return teacherRepository.findById(teacherId).get();
	}

	@Override
	public List<Teacher> displayAll() {
		return teacherRepository.findAll();
	}

	@Override
	public String updateTeacherRecord(Long teacherId, TeacherDto params) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		teacher.setTeacherName(params.getTeacherName());
		teacher.setEmail(params.getEmail());
		teacher.setContactNumber(params.getContactNumber());
		teacherRepository.save(teacher);
		return "Teacher Records Updated Successfully";
	}

	@Override
	public String deleteTeacherRecordById(Long teacherId) {
	  teacherRepository.deleteById(teacherId);
		return "Teacher details with id " + teacherId + " is deleted successfully";
	}

	@Override
	public String deleteAllTeacherRecords() {
		teacherRepository.deleteAll();
		return "All Teacher records deleted successfully";
	}

}

package com.schoolmgmnt.service;



import java.util.List;

import com.schoolmgmnt.dto.TeacherDto;
import com.schoolmgmnt.entity.Teacher;

public interface TeacherService {
	public Teacher addTeacherRecord(TeacherDto teacherDto);
	public Teacher getTeacherDetailsById(Long teacherId);
	public List<Teacher> displayAll();
	public String updateTeacherRecord(Long teacherId, TeacherDto params);
	public String deleteTeacherRecordById(Long teacherId);
	public String deleteAllTeacherRecords();

}

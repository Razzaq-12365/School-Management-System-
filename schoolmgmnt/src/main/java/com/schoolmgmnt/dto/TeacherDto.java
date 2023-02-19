package com.schoolmgmnt.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.schoolmgmnt.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {
	@NotNull(message="Id cannot be null")
	private Long teacherId;
	@NotEmpty(message="please enter hospital name")
	 @Size(max = 20, min = 3, message = "Invalid hospital name")
	private String teacherName;
	@Pattern(regexp = "\\d{10}", message = "contact number ust be 10 digits long")
	private String contactNumber;
	@Email(message = "invalid email format")
	private String email;
//	private List<Student> students;
}

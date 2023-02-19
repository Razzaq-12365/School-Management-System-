package com.schoolmgmnt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentDto {
	@NotNull(message="Id cannot be null")
	private Long studentId;
	@NotEmpty(message="please enter hospital name")
	 @Size(max = 20, min = 3, message = "Invalid hospital name")
	private String studentName;
	 @Email(message = "invalid email format")
	private String email;
	 @NotEmpty(message="please enter hospital name")
	 @Size(max = 20, min = 3, message = "Invalid hospital name")
	private String address;
	

}

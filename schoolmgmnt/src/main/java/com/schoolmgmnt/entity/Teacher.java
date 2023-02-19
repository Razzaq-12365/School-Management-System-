package com.schoolmgmnt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	private Long teacherId;
	@Column
	private String teacherName;
	@Column
	private String contactNumber;
	@Column
	private String email;
//	@OneToMany(cascade = CascadeType.ALL)
//	//name we can give anything which is a primary key of other table 
//	@JoinColumn(name="teacherId",referencedColumnName = "teacherId")
//	private List<Student> students;

}

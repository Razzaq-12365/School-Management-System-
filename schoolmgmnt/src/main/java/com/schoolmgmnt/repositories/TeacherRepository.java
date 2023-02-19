package com.schoolmgmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgmnt.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

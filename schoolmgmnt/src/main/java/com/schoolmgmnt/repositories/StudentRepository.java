package com.schoolmgmnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgmnt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

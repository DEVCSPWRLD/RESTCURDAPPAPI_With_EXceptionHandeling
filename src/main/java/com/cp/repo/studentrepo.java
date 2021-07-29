package com.cp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.entity.Student;

@Repository
public interface studentrepo extends JpaRepository<Student, Integer> {

}

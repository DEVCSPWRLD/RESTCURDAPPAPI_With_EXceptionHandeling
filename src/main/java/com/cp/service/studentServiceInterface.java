package com.cp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cp.entity.Student;
@Service
public interface studentServiceInterface {

	public Student addStudentDetails(Student student);

	public List<Student> getAllStudentData();

	public Student getStudentDataById(Integer sid);

	public void DeleteStudentDataById(Integer sid);

	public Student updateStudentDetails(Student student);

}

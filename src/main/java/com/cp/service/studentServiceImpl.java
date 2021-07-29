package com.cp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.customException.BusinessExcption;
import com.cp.customException.EmptyExcetion;
import com.cp.entity.Student;
import com.cp.repo.studentrepo;

@Service
public class studentServiceImpl implements studentServiceInterface {

	@Autowired
	private studentrepo repo;

	@Override
	public Student addStudentDetails(Student student) {

		if (student.getName().isEmpty() || student.getName().length() == 0) {
			throw new EmptyExcetion("601", "please send a proper name ,student name is empty");
		}
		try {
			Student savestudent = repo.save(student);
			return savestudent;
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BusinessExcption("602", "The student details is Null while Add Data" + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessExcption("603", "Something went wrong in  service layer while Add data" + e.getMessage());
		}

	}

	@Override
	public List<Student> getAllStudentData() {
		List<Student> student = null;
		try {

			student = repo.findAll();

		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessExcption("605",
					"Soething went wrong While retive all student data in service layer " + e.getMessage());
		}
		if (student.isEmpty()) {
			throw new BusinessExcption("604", "while get student data is empty in db there is no record");

		}
		return student;
	}

	@Override
	public Student getStudentDataById(Integer sid) {
		try {
			return repo.findById(sid).get();

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BusinessExcption("606",
					"The student details is Null while fetch student data by Id" + e.getMessage());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new BusinessExcption("607", "The Id is not avaliable in DB " + e.getMessage());

		}
	}

	@Override
	public void DeleteStudentDataById(Integer sid) {

		try {
			repo.deleteById(sid);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BusinessExcption("608",
					"The student details is Null while delete student data by Id" + e.getMessage());
		}

	}

	@Override
	public Student updateStudentDetails(Student student) {
		if (student.getName().isEmpty() || student.getName().length() == 0) {
			throw new BusinessExcption("611", "please send a proper name ,student name is empty while update data");
		}
		try {
			Student savestudent = repo.save(student);
			return savestudent;
		}

		catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new BusinessExcption("609", "The student details is Null while update Data" + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			throw new BusinessExcption("610", "Something went wrong in  service layer while Add data" + e.getMessage());
		}
	}
}

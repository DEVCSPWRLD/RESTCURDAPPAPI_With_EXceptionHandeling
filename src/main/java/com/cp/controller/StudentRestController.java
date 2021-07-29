package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.customException.BusinessExcption;
import com.cp.customException.ControllerException;
import com.cp.entity.Student;
import com.cp.service.studentServiceInterface;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private studentServiceInterface studentServiceInterface;

	// Save data
	@PostMapping("/save")
	public ResponseEntity<?> addStudentDetails(@RequestBody Student student) {
		
		/*
		 * try { Student studentdetailsAdd =
		 * studentServiceInterface.addStudentDetails(student); return new
		 * ResponseEntity<Student>(studentdetailsAdd, HttpStatus.CREATED); } catch
		 * (BusinessExcption e) { ControllerException ce = new
		 * ControllerException(e.getError_Code(), e.getError_Msg()); if (ce.error_Code
		 * == "601") {
		 * 
		 * return new ResponseEntity<ControllerException>(ce, HttpStatus.NOT_FOUND); }
		 * else { return new ResponseEntity<ControllerException>(ce,
		 * HttpStatus.BAD_REQUEST); }
		 * 
		 * } catch (Exception e) { ControllerException ce = new
		 * ControllerException("701", "Something went wrong in controller" +
		 * e.getMessage()); return new ResponseEntity<ControllerException>(ce,
		 * HttpStatus.BAD_REQUEST); }
		 */

		
		Student studentdetailsAdd = studentServiceInterface.addStudentDetails(student);
		return new ResponseEntity<Student>(studentdetailsAdd, HttpStatus.CREATED);

	}

	// Get all student data
	@GetMapping("/all")
	public ResponseEntity<?> getAllData() {

		try {
			List<Student> getAllstudentDatas = studentServiceInterface.getAllStudentData();
			return new ResponseEntity<List<?>>(getAllstudentDatas, HttpStatus.OK);
		} catch (BusinessExcption e) {
			ControllerException ce = new ControllerException(e.getError_Code(), e.getError_Msg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("702",
					"Something went wrong in controller" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// Get student data based on id
	@GetMapping("/student/{sid}")
	public ResponseEntity<?> getStudentDataById(@PathVariable("sid") Integer sid) {
		try {
			Student getstudentdataById = studentServiceInterface.getStudentDataById(sid);
			return new ResponseEntity<Student>(getstudentdataById, HttpStatus.OK);
		} catch (BusinessExcption e) {
			ControllerException ce = new ControllerException(e.getError_Code(), e.getError_Msg());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("703",
					"Something went wrong in controller" + e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// Delete student data
		@DeleteMapping("/delete/{sid}")
		public ResponseEntity<?> DeleteStudentDataById(@PathVariable("sid") Integer sid) {
			try {
				studentServiceInterface.DeleteStudentDataById(sid);
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			} catch (BusinessExcption e) {
				ControllerException ce = new ControllerException(e.getError_Code(), e.getError_Msg());
				return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				ControllerException ce = new ControllerException("704",
						"Something went wrong in controller" + e.getMessage());
				return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			}

		}
		
		// update student data
		@PutMapping("/update")
		public ResponseEntity<?> UpdateStudentDetails(@RequestBody Student student) {
			try {
				Student studentdetailsAdd = studentServiceInterface.updateStudentDetails(student);
				return new ResponseEntity<Student>(studentdetailsAdd, HttpStatus.CREATED);

			} catch (BusinessExcption e) {
				ControllerException ce = new ControllerException(e.getError_Code(), e.getError_Msg());
				return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				ControllerException ce = new ControllerException("705",
						"Something went wrong in controller" + e.getMessage());
				return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			}
		}

	}



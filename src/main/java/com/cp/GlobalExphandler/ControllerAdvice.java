package com.cp.GlobalExphandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cp.customException.EmptyExcetion;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(EmptyExcetion.class)
	public ResponseEntity<String> handler(EmptyExcetion emptyExcetion){
		return new ResponseEntity<String>("In put field is empty, please look into it", HttpStatus.BAD_REQUEST);
	}

}

package com.cp.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessExcption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String error_Code;
	public String error_Msg;
	
	public String getError_Code() {
		return error_Code;
	}
	public void setError_Code(String error_Code) {
		this.error_Code = error_Code;
	}
	public String getError_Msg() {
		return error_Msg;
	}
	public void setError_Msg(String error_Msg) {
		this.error_Msg = error_Msg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//Noarg constr
	public BusinessExcption() {
		
	}
	
	//Arg constr
	public BusinessExcption(String error_Code, String error_Msg) {
		super();
		this.error_Code = error_Code;
		this.error_Msg = error_Msg;
	}
	

}

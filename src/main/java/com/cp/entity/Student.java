package com.cp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_Details_Tab")
public class Student {
	@Id
	@GeneratedValue
	private Integer sid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "ADDRESS")
	private String address;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(Integer sid, String name, String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.address = address;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", address=" + address + "]";
	}

}

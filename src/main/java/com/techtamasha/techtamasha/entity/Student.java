package com.techtamasha.techtamasha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pisoft_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; // primary key

	public Student() {
	}

	
	@NotBlank
	@Column(name = "student_name")
	private String name;
	
	@NotBlank
	private String course;
	
	@NotNull
	private Integer age;
	private Integer phn;
	private String fatherName;
	private String motherName;

	public Student(Integer id, String name, String course, Integer age, Integer phn, String fatherName,
			String motherName) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.age = age;
		this.phn = phn;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getPhn() {
		return phn;
	}

	public void setPhn(Integer phn) {
		this.phn = phn;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", age=" + age + ", phn=" + phn
				+ ", fatherName=" + fatherName + ", motherName=" + motherName + "]";
	}
	
	

}

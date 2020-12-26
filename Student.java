package com.gmail.theslavahero;

import java.io.Serializable;

public class Student extends Human implements Serializable{
	private int grade;
	private int zachetNumber;

	public Student(int age, String name, String surname, double height, double weight, Gender sex, int grade,
			int zachetNumber) {
		super(age, name, surname, height, weight, sex);
		this.grade = grade;
		this.zachetNumber = zachetNumber;
	}

	public Student() {
		super();
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getZachetNumber() {
		return zachetNumber;
	}

	public void setZachetNumber(int zachetNumber) {
		this.zachetNumber = zachetNumber;
	}

	@Override
	public String toString() {
		return "Student [name = " + this.getName() + ", surname = " + this.getSurname() + ", age = " + this.getAge()
				+ ", zachet number = " + this.getZachetNumber() + ", height = " + this.getHeight() + ", weight = "
				+ this.getWeight() + ", sex = " + this.getSex() + ", grade = " + this.getGrade() + "]";
	}

}

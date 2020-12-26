package com.gmail.theslavahero;

import java.io.Serializable;
import java.util.Scanner;

public class Human implements Serializable{
	private int age;
	private String name;
	private String surname;
	private double height;
	private double weight;
	private Gender sex;

	public Human(int age, String name, String surname, double height, double weight, Gender sex) {
		super();
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.height = height;
		this.weight = weight;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}
	
	public void setSex(String sex) {
		Scanner sc = new Scanner(System.in);
		boolean correctArgument = false;
		while (!correctArgument) {
			if (sex.equals("MALE")) {
				this.sex = Gender.MALE;
				correctArgument = true;
			} else if (sex.equals("FEMALE")) {
				this.sex = Gender.FEMALE;
				correctArgument = true;
			} else if (!correctArgument) {
				System.out.println("Incorrect argument. Please, try again.");
				sex = sc.nextLine();
			}
		}
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + ", surname=" + surname + ", height=" + height + ", weight="
				+ weight + ", sex=" + sex + "]";
	}

}

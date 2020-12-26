package com.gmail.theslavahero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Student Alex1 = new Student(15, "Alex", "Barlow", 1.79, 74.5, Gender.MALE, 4, 7355);
		Student Alex2 = new Student(22, "James", "Holmes", 10.82, 69.5, Gender.FEMALE, 4, 7356);
		Student Alex3 = new Student(19, "Stephen", "Watson", 3.79, 75.5, Gender.MALE, 4, 7357);
		Student Alex4 = new Student(17, "Michael", "James", 5.79, 70.5, Gender.FEMALE, 4, 7358);
		Student Alex5 = new Student(14, "George", "Churchil", 19.79, 66.5, Gender.MALE, 4, 7359);
		Student Alex6 = new Student(20, "Andrei", "Cooper", 4.79, 71.5, Gender.FEMALE, 4, 7360);
		Student Alex7 = new Student(16, "Zion", "Stanley", 9.79, 72.5, Gender.MALE, 4, 7361);
		Student Alex8 = new Student(13, "Harry", "Potter", 6.79, 67.5, Gender.FEMALE, 4, 7362);
		Student Alex9 = new Student(21, "Ron", "Wisley", 8.79, 73.5, Gender.MALE, 4, 7363);
		Student Alex10 = new Student(18, "Anthony", "Curry", 7.79, 68.5, Gender.FEMALE, 4, 7364);

		Student[] students = new Student[10];
		Group group = new Group(students);
		group.addStudent(Alex1);
		group.addStudent(Alex2);
		group.addStudent(Alex3);
		group.addStudent(Alex4);
		group.addStudent(Alex5);
		group.addStudent(Alex6);
		group.addStudent(Alex7);
		group.addStudent(Alex8);
		group.addStudent(Alex9);
		group.addStudent(Alex10);


		group.saveGroup();
		Group group2 = new Group();
		group2.readGroup("group.bd");
		System.out.println(group2.toString());
		

		
		
		
		
	}

}

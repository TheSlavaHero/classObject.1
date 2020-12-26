package com.gmail.theslavahero;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Group implements Voenkom, Serializable {
	private Student[] studentGroup = new Student[10];

	public Group(Student[] studentGroup) {
		super();
		this.studentGroup = studentGroup;
	}

	public Group() {
		super();
	}

	public Student[] getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(Student[] studentGroup) {
		this.studentGroup = studentGroup;
	}

	public void deleteStudent(int zachetka) {
		try {
			boolean deleted;
			deleted = false;
			for (int i = 0; i < studentGroup.length; i++) {
				if (studentGroup[i] != null) {
					if (zachetka == studentGroup[i].getZachetNumber()) {
						studentGroup[i] = null;
						deleted = true;
					}
				}
			}
			if (!deleted) {
				System.out.println("В этой группе нет студента с зачеткой номер " + zachetka);
			}
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	public void addStudent(Student student) {
		try {
			boolean full;
			full = true;
			for (int i = 0; i < studentGroup.length; i++) {
				if (studentGroup[i] == null) {
					full = false;
					break;
				}
			}

			if (full) {
				throw new GroupOverloadException();
			}

			for (int i = 0; i < studentGroup.length; i++) {
				if (studentGroup[i] == null) {
					studentGroup[i] = student;
					break;
				}
			}

		} catch (GroupOverloadException e) {
			System.out.println(e.getMessage());
		}
	}

	public Student searchBySurnameStudent(String surname) {
		try {
			for (int i = 0; i < studentGroup.length; i++) {
				if (studentGroup[i] != null) {
					if (studentGroup[i].getSurname() == surname) {
						return studentGroup[i];
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
		return null;
	}

	public void studentList() {
		Scanner sc = new Scanner(System.in);
		boolean correctInput = false;
		int variant = 0;
		System.out.println("Введите, по какому параметру вы хотите отсортировать студентов");
		System.out.println("1 - имя, 2 - фамилия, 3 - высота, 4 - вес, 5 - пол, 6 - оценка, 7 - зачетка, 8 - возраст");
		while (!correctInput) {
			try {
				variant = sc.nextInt();
				if (variant > 0 && variant < 9) {
					correctInput = true;
				} else {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
		studentListVariant(variant);
	}

	private void studentListVariant(int variant) {
		switch (variant) {

		case (1):
			sortName();
			break;
		case (2):
			sortSurname();
			break;
		case (3):
			sortHeight();
			break;
		case (4):
			sortWeight();
			break;
		case (5):
			sortSex();
			break;
		case (6):
			sortGrade();
			break;
		case (7):
			sortZachetNumber();
			break;
		case (8):
			sortAge();
			break;
		}
	}

	private void sortName() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getName().charAt(0) > studenti[i + 1].getName().charAt(0)) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortSurname() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getSurname().charAt(0) > studenti[i + 1].getSurname().charAt(0)) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortHeight() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getHeight() > studenti[i + 1].getHeight()) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortWeight() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getWeight() > studenti[i + 1].getWeight()) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortSex() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getSex() == Gender.FEMALE && studenti[i + 1].getSex() == Gender.MALE) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortGrade() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getGrade() > studenti[i + 1].getGrade()) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortZachetNumber() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getZachetNumber() > studenti[i + 1].getZachetNumber()) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	private void sortAge() {
		try {
			Student studentTemp;
			Group gruppa = this.clearNull();
			Student[] studenti = gruppa.getStudentGroup();

			for (int i = 0; i < studenti.length - 1; i++) {
				if (studenti[i].getAge() > studenti[i + 1].getAge()) {
					studentTemp = studenti[i];
					studenti[i] = studenti[i + 1];
					studenti[i + 1] = studentTemp;
					i = -1;
				}
			}
			System.out.println(Arrays.toString(studenti));
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		}
	}

	public Student zachetNumberSearch(int zachetNumber) {

		for (int i = 0; i < studentGroup.length; i++) {
			Student student = studentGroup[i];
			if (student.getZachetNumber() == zachetNumber) {
				return student;
			}
		}
		return null;
	}

	public void createStudent() {
		try {
			Scanner sc = new Scanner(System.in);
			Student student = new Student();
			System.out.println("Введите возраст студента");
			scanAge(student);
			System.out.println("Введите имя студента");
			scanName(student);
			System.out.println("Введите фамилию студента");
			scanSurname(student);
			System.out.println("Введите высоту студента");
			scanHeight(student);
			System.out.println("Введите вес студента");
			scanWeight(student);
			System.out.println("Введите пол студента (MALE/FEMALE)");
			String sex = sc.nextLine();
			student.setSex(sex);
			System.out.println("Введите среднюю оценку студента");
			scanGrade(student);
			System.out.println("Введите номер зачетки студента");
			scanZachetNumber(student);
			this.addStudent(student);
		} catch (NullPointerException e) {
			System.out.println("A NullPointerException has occured.");
		} catch (NumberFormatException e) {
			System.out.println("A NumberFormatException has occured.");
		} catch (InputMismatchException e) {
			System.out.println("An InputMismatchException has occured.");
		}
	}

	private void scanAge(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				int age = sc.nextInt();
				student.setAge(age);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanName(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				String name = sc.nextLine();
				student.setName(name);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanSurname(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				String surname = sc.nextLine();
				student.setSurname(surname);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanHeight(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				double height = sc.nextDouble();
				student.setHeight(height);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanWeight(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				double weight = sc.nextDouble();
				student.setWeight(weight);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanGrade(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				int grade = sc.nextInt();
				student.setGrade(grade);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	private void scanZachetNumber(Student student) {
		boolean correctInput = false;
		Scanner sc = new Scanner(System.in);
		while (!correctInput) {
			try {
				int zachetNumber = sc.nextInt();
				student.setZachetNumber(zachetNumber);
				correctInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Incorrect argument. Please, try again.");
				sc = new Scanner(System.in);
			}
		}
	}

	public Group clearNull() {
		int nullCounter = 0;
		for (int i = 0; i < studentGroup.length; i++) {
			if (studentGroup[i] == null) {
				nullCounter++;
			}
		}
		Student[] students = new Student[10 - nullCounter];
		int j = 0;
		for (int i = 0; i < studentGroup.length - 1; i++) {
			if (studentGroup[i] != null) {
				students[j] = studentGroup[i];
				j++;
			}
		}
		Group studentGr = new Group(students);
		return studentGr;
	}

	public void saveGroup() {
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("group.bd"))) {
			OOS.writeObject(this.studentGroup);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readGroup(String fileName) {
		
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(fileName))) {
			this.studentGroup = (Student []) OIS.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load group !!!");
		}
	}

	private Student stringToStudent(String studentStr) {
		Student student = new Student();
		int index1 = studentStr.indexOf("name = ") + 7;
		int index2 = studentStr.indexOf(", surname = ");
		student.setName(studentStr.substring(index1, index2));
		index1 = index2 + 12;
		index2 = studentStr.indexOf(", age = ");
		student.setSurname(studentStr.substring(index1, index2));
		index1 = index2 + 8;
		index2 = studentStr.indexOf(", zachet number = ");
		student.setAge(Integer.parseInt(studentStr.substring(index1, index2)));
		index1 = index2 + 18;
		index2 = studentStr.indexOf(", height = ");
		student.setZachetNumber(Integer.parseInt(studentStr.substring(index1, index2)));
		index1 = index2 + 11;
		index2 = studentStr.indexOf(", weight = ");
		student.setHeight(Double.parseDouble(studentStr.substring(index1, index2)));
		index1 = index2 + 11;
		index2 = studentStr.indexOf(", sex = ");
		student.setWeight(Double.parseDouble(studentStr.substring(index1, index2)));
		index1 = index2 + 8;
		index2 = studentStr.indexOf(", grade = ");
		student.setSex(studentStr.substring(index1, index2));
		index1 = index2 + 10;
		index2 = studentStr.indexOf("]");
		student.setGrade(Integer.parseInt(studentStr.substring(index1, index2)));
		return student;
	}

	@Override
	public String toString() {
		return "Group [studentGroup=" + Arrays.toString(studentGroup) + "]";
	}

	@Override
	public Student[] getRecruiters() {
		Group group = new Group(studentGroup);
		Group group2 = group.clearNull();
		int squadSize = 0;
		for (int i = 0; i < group2.getStudentGroup().length; i++) {
			if (group2.studentGroup[i].getAge() >= 18 && group2.studentGroup[i].getSex() == Gender.MALE) {
				squadSize++;
			}
		}
		Student[] squad = new Student[squadSize];
		int j = 0;
		for (int i = 0; i < group2.getStudentGroup().length; i++) {
			if (group2.studentGroup[i].getAge() >= 18 && group2.studentGroup[i].getSex() == Gender.MALE) {
				squad[j] = group2.studentGroup[i];
				j++;
			}
		}
		return squad;
	}

}

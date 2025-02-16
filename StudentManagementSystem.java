package StudentRecord;

import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String course;
    double marks;

    public Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public void display() {
        System.out.println();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println();
    }
}

public class StudentManagementSystem {
    static Student[] students = new Student[100]; // Fixed-size array
    static int count = 0; // Tracks number of students
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Student Management System");
            System.out.println("1. Add Student.");
            System.out.println("2. View Students.");
            System.out.println("3. Update Student.");
            System.out.println("4. Delete Student.");
            System.out.println("5. Exit!!");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear buffer
            }
        }
    }

    // Add a new student
    public static void addStudent() {
        try {
            if (count >= students.length) {
                System.out.println("Student list is full!");
                return;
            }
            System.out.println();
            System.out.println("Add Student");
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            students[count++] = new Student(rollNo, name, course, marks);
            System.out.println("Student added successfully!");
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter the correct data type.");
            sc.nextLine(); // Clear buffer
        }
    }

    // View all students
    public static void viewStudents() {
        if (count == 0) {
            System.out.println("No students found!");
            return;
        }
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    // Update student details
    public static void updateStudent() {
        try {
            System.out.println();
            System.out.println("Update Student");
            System.out.print("Enter Roll No to update: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (students[i].rollNo == rollNo) {
                    System.out.print("Enter New Name: ");
                    students[i].name = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    students[i].course = sc.nextLine();
                    System.out.print("Enter New Marks: ");
                    students[i].marks = sc.nextDouble();
                    System.out.println("Student updated successfully!");
                    System.out.println();
                    return;
                }
            }
            System.out.println("Student not found!");
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter the correct data type.");
            sc.nextLine(); // Clear buffer
        }
    }

    // Delete a student
    public static void deleteStudent() {
        try {
            System.out.print("Enter Roll No to delete: ");
            int rollNo = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (students[i].rollNo == rollNo) {
                    for (int j = i; j < count - 1; j++) {
                        students[j] = students[j + 1]; // Shift elements left
                    }
                    students[--count] = null; // Reduce count and remove last entry
                    System.out.println("Student deleted successfully!");
                    System.out.println();
                    return;
                }
            }
            System.out.println("Student not found!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid Roll No.");
            sc.nextLine(); // Clear buffer
        }
    }
}


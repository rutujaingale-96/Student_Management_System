
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x=0;
        while (x!=1) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 :
                 addStudent();
                 break;
                case 2 :
                 viewStudents();
                 break;
                case 3 :
                 updateStudent();
                 break;
                case 4 :
                 deleteStudent();
                 break;
                case 5 :
                 {
                    System.out.println("Exiting... Goodbye!");
                   x=1;
                }
                break;
                default :
                 System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    static void addStudent() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        
        System.out.println("Enter Student Name: ");
        String name = sc.next();
        
        System.out.println("Enter Student Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student student : students) {
            if (student.id == id) {
                
                System.out.println("Enter New Name: ");
                student.name = sc.nextLine();
                
                System.out.println("Enter New Age: ");
                student.age = sc.nextInt();
                
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}



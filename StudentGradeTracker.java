import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    ArrayList<Integer> marks = new ArrayList<>();

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void addMark(int mark) {
        marks.add(mark);
    }

    double calculateAverage() {
        if (marks.size() == 0) return 0;
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.size();
    }

    char calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    void displayReport() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println("-------------------------");
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Student s = new Student(name, roll);

            System.out.print("Enter number of subjects: ");
            int sub = sc.nextInt();
            for (int j = 0; j < sub; j++) {
                System.out.print("Enter mark for subject " + (j+1) + ": ");
                s.addMark(sc.nextInt());
            }
            sc.nextLine(); // consume newline

            students.add(s);
            System.out.println("Student added successfully!\n");
        }

        // Display report of all students
        System.out.println("\n=== Student Report Card ===");
        for (Student s : students) {
            s.displayReport();
        }

        sc.close();
    }
}

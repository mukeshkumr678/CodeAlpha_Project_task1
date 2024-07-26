import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<StudentGrade> studentGrades = new ArrayList<>();

        System.out.println("Enter student name and grade. Type 'done' to finish:");

        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();

            studentGrades.add(new StudentGrade(name, grade));
        }

        if (studentGrades.size() == 0) {
            System.out.println("No grades entered.");
            return;
        }

        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        String maxName = "";
        String minName = "";

        for (StudentGrade studentGrade : studentGrades) {
            double grade = studentGrade.getGrade();
            sum += grade;
            if (grade > max) {
                max = grade;
                maxName = studentGrade.getName();
            }
            if (grade < min) {
                min = grade;
                minName = studentGrade.getName();
            }
        }

        double average = sum / studentGrades.size();

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + max + " by " + maxName);
        System.out.println("Lowest grade: " + min + " by " + minName);
    }
}


 class StudentGrade {
    private final String name;
    private final double grade;

    public StudentGrade(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}


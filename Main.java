import java.util.*;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    Subject subject[];
    String name;
    String usn;
    double sgpa;
    Scanner sc;

    Student() {
        int i;
        subject = new Subject[8];
        sc = new Scanner(System.in);
        for (i = 0; i < 8; i++)
            subject[i] = new Subject();
    }

    void getstudentdetails() {
        System.out.println("Enter your name:");
        this.name = sc.next();
        System.out.println("Enter your USN:");
        this.usn = sc.next();
    }

    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ":");
            subject[i].subjectMarks = sc.nextInt();
            System.out.println("Enter credits for subject" + (i + 1) + ":");
            subject[i].credits = sc.nextInt();
            subject[i].grade = subject[i].subjectMarks / 10 + 1;
            if (subject[i].grade == 11)
                subject[i].grade = 10;
            if (subject[i].grade <= 4)
                subject[i].grade = 0;
        }
    }

    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;
        for (int i = 0; i < 8; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }
        sgpa = (double) effectiveScore / (double) totalCredits;
    }

}

class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.getstudentdetails();
        s1.getMarks();
        s1.computeSGPA();
        System.out.println("Name=" + s1.name);
        System.out.println("USN:" + s1.usn);
        System.out.println("SGPA=" + s1.sgpa);
    }
}
package College;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String degreeCourse = "";
    private String specialization = "";
    private int year = 0;
    private int group = 0;
    private int studentID = 0;
    List<FinalGrade> finalGrades = new ArrayList<>();
    
    public Student(){}

    public Student(String name, String surname, String birthDate, String degreeCourse, String specialization, int year, int group, int studentID){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.degreeCourse = degreeCourse;
        this.specialization = specialization;
        this.year = year;
        this.group = group;
        this.studentID = studentID;
    }

    public String getDegreeCourse() {return degreeCourse;}
    public String getSpecialization() {return specialization;}
    public int getYear() {return year;}
    public int getGroup() {return group;}
    public int getStudentID() {return studentID;}
    public void setDegreeCourse(String degreeCourse) {this.degreeCourse = degreeCourse;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}
    public void setYear(int year) {this.year = year;}
    public void setGroup(int group) {this.group = group;}
    public void setStudentID(int studentID) {this.studentID = studentID;}

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Degree course: " + degreeCourse);
        System.out.println("Specialization: " + specialization);
        System.out.println("Year: " + year);
        System.out.println("Group: " + group);
        System.out.println("Student ID:  " + studentID);
        System.out.println();
    }

    public void addGrade(Course course, double grade, String date){
        finalGrades.add(new FinalGrade(grade, date, course));
    }

    public void infoGrades(){
        finalGrades.forEach((grade) -> {
            grade.printInfo();
        });
    }
}

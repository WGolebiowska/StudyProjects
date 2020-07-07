package College;

public class Course implements IInfo {
    private String name = "";
    private String degreeCourse = "";
    private String specialization = "";
    private int semester = 0;
    private int courseCredit = 0;
    
    public Course(String name, String degreeCourse, String specialization, int semester, int courseCredit){
        this.name = name;
        this.degreeCourse = degreeCourse;
        this.specialization = specialization;
        this.semester = semester;
        this.courseCredit = courseCredit;
    }
    
    public String getName() {return name;}
    public String getDegreeCourse() {return degreeCourse;}
    public String getSpecialization() {return specialization;}
    public int getSemester() {return semester;}
    public int getCourseCredit() {return courseCredit;}
    public void setName(String name) {this.name = name;}
    public void setDegreeCourse(String degreeCourse) {this.degreeCourse = degreeCourse;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}
    public void setSemester(int semester) {this.semester = semester;}
    public void setCourseCredit(int courseCredit) {this.courseCredit = courseCredit;}

    public void printInfo() {
        System.out.println("Course name: " + name);
        System.out.println(degreeCourse + ", " + specialization);
        System.out.println("Semester: " + semester);
        System.out.println("Course credit: " + courseCredit);
        System.out.println();
    }
}

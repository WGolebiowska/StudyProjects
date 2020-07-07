package College;


public class FinalGrade implements IInfo{
    private double value = 0.0;
    private String date = "";
    private Course course;
    
    public FinalGrade(double grade, String date, Course course){
        this.value = grade;
        this.date = date;
        this.course = course;
    }
    
    public double getValue() {return value;}
    public String getDate() {return date;}
    public Course getPrzedmiot() {return course;}
    public void setValue(double value) {this.value = value;}
    public void setDate(String date) {this.date = date;}
    public void setPrzedmiot(Course course) {this.course = course;}
    
    @Override
    public void printInfo(){
        System.out.println(value + ",  " + date);
        course.printInfo();
    }
}

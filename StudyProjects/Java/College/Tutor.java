package College;

public class Tutor extends Person {

    private String degree="";
    private String jobTitle = "";

    public Tutor(){}
    
    public Tutor(String name, String surname, String birthDate, String degree, String jobTitle){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.degree = degree;
        this.jobTitle = jobTitle;
    }

    public String getDegree() {return degree;}
    public String getJobTitle() {return jobTitle;}
    public void setDegree(String degree) {this.degree = degree;}
    public void setJobTitle(String jobTitle) {this.jobTitle = jobTitle;}

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Degree: " + degree);
        System.out.println("Job title: " + jobTitle);
        System.out.println();
    }
}

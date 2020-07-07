package College;

public class Person implements IInfo{
    
    protected String name = "";
    protected String surname = "";
    protected String birthDate = "";
    
    public Person(){}

    public Person(String name, String surname, String birthDate){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getBirthDate() {return birthDate;}
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setBirthDate(String birthDate) {this.birthDate = birthDate;}

    public void printInfo(){
        System.out.println(name + " " + surname);
        System.out.println("Date of birth: " + birthDate);
        System.out.println();
    }
}
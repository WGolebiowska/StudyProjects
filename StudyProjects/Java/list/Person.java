package list;


public class Person {
    public String name;
    public String surname;
    
    public Person(){
        this.name = "";
        this.surname = "";
    }
    
    public Person(String name, String surname){
        this.surname = "";
        this.name = name;
        this.surname = surname;
    }
    
    public void printInfo(){
        System.out.println(name + " " + surname);
    }
}

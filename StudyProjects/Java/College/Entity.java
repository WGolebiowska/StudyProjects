package College;

import java.util.LinkedList;
import java.util.List;

public class Entity implements IInfo{
    
    private String name = "";
    private String address = "";
    List<Tutor> tutors = new LinkedList<>();    
    
    public Entity(String name, String address){
        this.name = name;
        this.address = address;
    }
    
    public String getName() {return name;}
    public String getAddress() {return address;}
    public void setName(String name) {this.name = name;}
    public void setAddress(String address) {this.address = address;}
    
    public void addTutor(Tutor t){
        tutors.add(t);
    }
    
    public boolean deleteTutor(Tutor t){
        return tutors.remove(t);
    }
    
    public boolean deleteTutor(String name, String surname){
        for(Tutor t : tutors) {
            if(t.getName() == name && t.getSurname() == surname){
                    return tutors.remove(t);
                }
            }
        return false;
    }
    
    public void infoTutors(){
        for(Tutor t : tutors){
            t.printInfo();
        }  
    }
    
    @Override
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println();
    }
}

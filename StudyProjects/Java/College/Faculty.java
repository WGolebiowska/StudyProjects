package College;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    List<Course> courses = new ArrayList<>();
    List<Student> students = new ArrayList<>();    
    List<Entity> entities = new ArrayList<>();
    
    Faculty(){}
    
    public void addEntity(String name, String address){
        entities.add(new Entity(name, address));
    }
    
    public void addCourse(Course course){
        courses.add(course);
    }
    
    public void addStudent(Student student){
        students.add(student);
    }
    
    public boolean addTutor(Tutor tutor, String nameOfEntity){
        for(Entity entity : entities){
            if(entity.getName() == nameOfEntity){
                entity.addTutor(tutor);
                return true;
            }
        }
        return false;
    }
    
    public void infoStudents(boolean infoGrades){
        if(infoGrades == true){
            for(Student students : students){
                students.printInfo();
                students.infoGrades();
            }
        } else {
            for(Student student : students)
                student.printInfo();
        }   
    }
    
    public void infoEntities(boolean infoTutors){
        if(infoTutors == true){
            for(Entity entity : entities){
                entity.printInfo();
                entity.infoTutors();
            }
        } else {
            for(Entity entity : entities)
                entity.printInfo();
        }
    }
    
    public void infoCourses(){
        courses.forEach((course) -> {
            course.printInfo();
        });    
    }
    
    public boolean addGrade(int studentID, String course, double grade, String date){
        
        for(Course p : courses) {
            if(p.getName() == course){
                for(Student s : students) {
                    if(s.getStudentID() == studentID){
                        s.addGrade(p, grade, date);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean deleteStudent(int studentID){
        for(Student student : students) {
            if(student.getStudentID() == studentID)
                    return students.remove(student);
            }
        return false;
    }
    
    public boolean moveTutor(Tutor tutor, String currentEntity, String newEntity){
        boolean b = false;
            for(Entity entity : entities){
                if(entity.getName() == currentEntity)
                    b = entity.deleteTutor(tutor);
            }
            
            if(b == true){
                for(Entity entity : entities){
                    if(entity.getName() == newEntity)
                        entity.addTutor(tutor);
                }
            }                
        return b;
    }
}

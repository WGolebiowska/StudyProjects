package queue;

public class Element{
    public Object value;
    public Element nextElement;
    
    public Element(){
        this.value = 0;
        this.nextElement = null;
    }
    
    public Element(Object value){
        this.value = value;
        this.nextElement = null;
    }
    
    public void setNextElement(Element nextElement){
        this.nextElement = nextElement;
    }
 
    public Element getNextElement(){
        return nextElement;
    }
 
    public Object getValue(){
        return value;
    }
}

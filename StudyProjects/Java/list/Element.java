package list;


public class Element{
    public Person value;
    public Element nextElement;
    
    public Element(){
        this.value = null;
        this.nextElement = null;
    }
    
    public Element(Person value){
        this(value, null);
    }
    
    public Element(Person value, Element nextElement){
	this.value = value;
	this.nextElement = nextElement;
    }
    
    public void setNextElement(Element nextElement){
        this.nextElement = nextElement;
    }
 
    public Element getNextElement(){
        return nextElement;
    }
 
    public Person getValue(){
        return value;
    }
}

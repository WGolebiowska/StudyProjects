package stack;


public class Element{
    public Book value;
    public Element nextValue;
    
    public Element(){
        this.value = null;
        this.nextValue = null;
    }
    
    public Element(Book value){
        this(value, null);
    }
    
    public Element(Book value, Element nextElement){
	this.value = value;
	this.nextValue = nextElement;
    }
    
    public void setNextValue(Element nextValue){
        this.nextValue = nextValue;
    }
 
    public Element getNextValue(){
        return nextValue;
    }
 
    public Book getValue(){
        return value;
    }
}

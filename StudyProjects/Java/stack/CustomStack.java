package stack;


public class CustomStack {
    public Element stackTop;
    public int numberOfElements;
    
    public CustomStack(){
        stackTop = null;
        numberOfElements = 0;
    }
    
    public Element getStackTop(){
        return stackTop;
    }
 
    public void setStackTop(Element stackTop){
        this.stackTop = stackTop;
    }
    
    public int getNumberOfElements(){return numberOfElements;}   
    
    public void push(Book value){
        Element temp = new Element(value, stackTop);
        stackTop = temp;
        numberOfElements++;
    }
    
    public Element pop(){
        Element temp = null;
        if(stackTop != null){
            temp = stackTop;
            stackTop = stackTop.getNextValue();
            numberOfElements--;
        } else {
            System.out.println("Stack is empty");
        }
        return temp;
    }
   
    public void print(){
        
        if(stackTop != null){
            Element temp = stackTop;
            
            for(int i = 0; i < numberOfElements; i++){
                temp.value.printInfo();
                temp = temp.getNextValue();
            }
            
            System.out.println();
        }
        else {
            System.out.println("Stack is empty");
        }
    }
}

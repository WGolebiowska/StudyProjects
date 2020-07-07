package list;


public class CustomList {
    public Element firstElement;
    public int numberOfElements;
    
    public CustomList(){
        firstElement = null;
        numberOfElements = 0;
    }
    
    public Element getFirstElement(){
        return firstElement;
    }
 
    public void setFirstElement(Element firstElement){
        this.firstElement = firstElement;
    }
    
    public int getNumberOfElements(){return numberOfElements;}   
    
    public void dodaj(Person value){
        if(this.getFirstElement() == null){
            this.setFirstElement(new Element(value));
        }
        else{
            Element lastElement = this.getFirstElement();
            while(lastElement.getNextElement() != null)
                lastElement = lastElement.getNextElement();
            
            lastElement.setNextElement(new Element(value));
        }
        numberOfElements++;
    }
        

    public Person getElement(int indexOfElement){
        if(indexOfElement < 0 || indexOfElement > numberOfElements) 
            throw new IndexOutOfBoundsException();
        
        Element temp = firstElement;
        
        if (indexOfElement == 0) 
        { 
            firstElement = temp.nextElement;
            numberOfElements--;
            return temp.getValue(); 
        } 
  
        for (int i = 0; temp != null && i < indexOfElement-1; i++) 
            temp = temp.nextElement;
  
        Element next = temp.nextElement.nextElement; 
  
        temp.nextElement = next;
        numberOfElements--;
        return temp.getValue();
    } 
    
    public void addToList(Person value, int indexOfElement){
        if(indexOfElement < 0 || indexOfElement > numberOfElements) 
            throw new IndexOutOfBoundsException();
        
        Element temp = new Element(value);
        
        if(indexOfElement == 0){
            temp.nextElement = firstElement;
            firstElement = temp;
        } else {
            Element temp2 = firstElement;
            
            while(--indexOfElement > 0){
                temp2 = temp2.nextElement;
            }
            
            temp.nextElement = temp2.nextElement;
            temp2.nextElement = temp;
        }
        numberOfElements++;
        } 
    
    public void printList(){
        
        if(firstElement != null){
            Element temp = firstElement;
            for(int i = 0; i < numberOfElements; ++i){
                temp.value.printInfo();
                temp = temp.getNextElement();
            }
                        System.out.println();
        }
        else {
            System.out.println("List is empty");
        }
    }
}

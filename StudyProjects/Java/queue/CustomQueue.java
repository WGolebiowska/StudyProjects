/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author mvl
 */
public class CustomQueue {
    public Element pierwszyElement;
    public Element ostatniElement;
    public int liczbaElementow;
    
    public CustomQueue(){
        pierwszyElement = null;
        ostatniElement = null;
        liczbaElementow = 0;
    }
    
    public Element getPierwszyElement(){
        return pierwszyElement;
    }
 
    public Element getOstatniElement(){
        return ostatniElement;
    }
 
    public void ostatniElement(Element ostatniElement){
        this.ostatniElement = ostatniElement;
    }
 
    public void setPierwszyElement(Element pierwszyElement){
        this.pierwszyElement = pierwszyElement;
    }
    
    public int getLiczbaElementow(){return liczbaElementow;}   
    
    public void dodaj(Object element){
        Element temp = new Element(element);
        if(pierwszyElement == null){
            pierwszyElement = ostatniElement = temp;
        }
        else{
            ostatniElement.setNextElement(temp);
            temp.setNextElement(ostatniElement);
            ostatniElement = temp;
        }
        liczbaElementow++;
    }
    

    
    public Object pobierz(){
        Element temp = new Element(pierwszyElement.getValue());
            if(pierwszyElement.getNextElement() == null){
                ostatniElement = null;
            }
            pierwszyElement = pierwszyElement.getNextElement();
        
        liczbaElementow--;
        
        return temp.getValue();
    }
    
    
    public void wypisz(){
        if(pierwszyElement != null){
            Element temp = pierwszyElement;
            for(int i = 0; i < liczbaElementow; ++i){
                System.out.println(temp.getValue() + " ");
                temp = temp.getNextElement();
            }
                        System.out.println();
        }
        else {
            System.out.println("Kolejka jest pusta");
        }
    }
}

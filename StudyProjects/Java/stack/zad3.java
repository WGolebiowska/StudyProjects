/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import list.Stos;

/**
 *
 * @author mvl
 */
public class zad3 {
    public static void main(String[]args){
        Book k1 = new Book("Lalka", "Bolesław Prus", 2008);
        Book k2 = new Book("Zbrodnia i kara", "Fjodor Dostojewski", 2005);
        Book k3 = new Book("Ferdydurke", "Witold Gombrowicz", 2015);
        Book k4 = new Book("Pan Tadeusz", "Adam Mickiewicz", 2009);
        Stos s = new Stos();
        
        s.push(k1);
        s.push(k2);
        s.push(k3);
        s.wypisz();

        s.pop();
        s.wypisz();
        
        s.pop();
        s.wypisz();
        
        s.pop();
        s.push(k4);
        s.wypisz();    
    }
}

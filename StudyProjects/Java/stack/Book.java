/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author mvl
 */
public class Book {
    public String tytul;
    public String autor;
    public int rokWydania;
    
    public Book(){
        this.tytul = "nieznany";
        this.autor = "nieznany";
        this.rokWydania = 0;
    }
    
    public Book(String tytul, String autor, int rokWydania){
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }
    
    public void printInfo(){
        System.out.println("Tytuł: " + tytul);
        System.out.println("Autor: " + autor);
        System.out.println("Rok wydania: " + rokWydania);
    }
}

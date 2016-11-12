/**
 * Programação Orientada a Objetos 2 - AA4-1
 * Professor: Delano Medeiros Beder
 * Tutor: Fernando Chagas
 * 
 * GABRIEL MACHADO SANTOS 581062
 * JOAO PAULO FRANCELINO MONTEIRO 545767
 * DANIEL JOSE CONSTANTINO 580996 
 * 
 * 12/nov/2016
 */
package br.ufscar.si.catalogo;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Mídia implements Serializable, Comparable<Mídia>{

    private String título;
    private int anoCriação;
    
    public Mídia(String título, int anoCriação){
        this.título = título;
        this.anoCriação = anoCriação;
    }
    
    public void setTítulo(String título){
        this.título = título;
    }
    
    public String getTítulo(){
        return this.título;
    }
    
    public void setAno(int ano){
        this.anoCriação = ano;
    }
    
    public int getAno(){
        return this.anoCriação;
    }
    
    
    public abstract int getTipo();
    public abstract void imprimeFicha();
    public abstract StringBuilder imprimeFichaGUI();
       
    @Override
    public int compareTo(Mídia midia) {
       if (this.getAno() != midia.getAno()) {
           return this.getAno() - midia.getAno(); // retorna negativo se this.getAno() < midia.getAno()
                                                  // retorna positivo se this.getAno() > midia.getAno()          
       } else {
           return this.getTítulo().compareTo(midia.getTítulo()); 
       }
    }
}

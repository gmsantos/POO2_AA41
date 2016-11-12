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

import java.util.*;
import java.io.Serializable;

public class Catálogo implements ColeçãoMídia, Serializable{ 
    List <Mídia> catalogo; 
    int MAX_SIZE = 0; //Varável que irá armazenar o tamanho máximo da coleção atribuído no construtor
    
    public Catálogo(int tamMax){ 
        if (tamMax > 300){ // Verifica o tamanho máximo
            tamMax = 300;
        }
        catalogo = new ArrayList<>(tamMax);
        MAX_SIZE = tamMax;
    }
    
    public boolean adicionaMídia(Mídia mídia){ // Método para adicionar Mídias
        if (this.catalogo.size() < this.MAX_SIZE) { // Verifica o limite atribuído no construtor
            this.catalogo.add(mídia);
            return true; 
        }
        return false; 
    }
    
    public Mídia obtemMídia(String título){ // Checa se existe título na coleção
        for (Mídia catalogo1 : this.catalogo){
            if (catalogo1 != null){
                if (catalogo1.getTítulo().equals(título)){
                    return catalogo1; 
                }
            }
        }
        return null; 
    }
    
    public int quantidadeMáximaDeMídias(){ // Método que retorna a quantidade máxima de Mídias
        return this.MAX_SIZE;
    }
    
    public int quantidadeDeMídias(){ // Quantidade de Mídias existentes
        return this.catalogo.size();
    } 
    
    public int quantidadeDeCDs(){ //Retornaa quantidade de CDs
        
        int CDs = 0;
        for (Mídia catalogo1 : this.catalogo) {
            if (catalogo1 != null) {
                if (catalogo1.getTipo() == 1) {
                    CDs+=1;
                }
            }
        }
        return CDs;
    }
    
    public int quantidadeDeDVDs(){ //Retorna a quantidade de DVDs
        int DVDs = 0;
        for (Mídia catalogo1 : this.catalogo) {
            if (catalogo1 != null) {
                if (catalogo1.getTipo() == 2) {
                    DVDs+=1;
                }
            }
        }
        return DVDs;
    }
    
    public int quantidadeDeJogos(){ // Retorna a quantidade de Jogos
        int Jogos = 0;
        for (Mídia catalogo1 : this.catalogo) {
            if (catalogo1 != null) {
                if (catalogo1.getTipo() == 3) {
                    Jogos+=1;
                }
            }
        }
        return Jogos;
    }
    
    @Override 
    public List<Mídia> coleção(){
        List<Mídia> colecao; 
        int total = this.catalogo.size(); // Total de mídias
        
        if(total > 0){
            colecao = new ArrayList<>();
            
            this.catalogo.stream().filter((x) -> (x != null)).forEach((x) -> {
                colecao.add(x);
            });

            //Ordenando a Coleção            
            Collections.sort(colecao);
            return colecao; // retorna as midias total
        }
        else return null;
    }
    
    public void imprimeColeção(){ 
        List<Mídia> colecao = this.coleção();
        
        colecao.stream().filter((x) -> (x != null)).forEach((x) -> {
            x.imprimeFicha(); // Método é extendido ao objeto
        });
    }
    public StringBuilder imprimeColeçãoGUI(){ 
        List<Mídia> colecao = this.coleção();
        StringBuilder stringBuilder = new StringBuilder();
        
        colecao.stream().filter((x) -> (x != null)).forEach((x) -> {
            stringBuilder.append(x.imprimeFichaGUI()).append(System.getProperty("line.separator")); // Método é extendido ao objeto
            stringBuilder.append("----------------------------------------------------------").append(System.getProperty("line.separator"));
        });
        return stringBuilder;
        
    }

    @Override 
    public List<Mídia> coleçãoPorTipo(int tipo){
        List<Mídia> colecaoTipo; 
        int total = this.catalogo.size(); // Total de mídias
        
        if(total > 0){
            colecaoTipo = new ArrayList();
            int indice = 0;
            
            for (Mídia x : this.catalogo) {
                if(x != null){
                    if(x.getTipo() == tipo) { 
                        colecaoTipo.add(indice, x); 
                        indice += 1;
                    }
                }
            }
            
            //Ordenando a coleçao
            Collections.sort(colecaoTipo);
            
            return colecaoTipo; // Retorna a coleção
        }
        else return null;
    }
    
    public void imprimeColeçãoPorTipo(int tipo){ // Esse método a mesma coisa, mas por tipo
        List<Mídia> colecaoTipo = coleçãoPorTipo(tipo);
        
        colecaoTipo.stream().forEach((x) -> {
            x.imprimeFicha(); //Método é extendido ao objeto
        });
    }   
    
    public StringBuilder imprimeColeçãoPorTipoGUI(int tipo){ // Esse método a mesma coisa, mas por tipo
        List<Mídia> colecaoTipo = coleçãoPorTipo(tipo);
        StringBuilder stringBuilder = new StringBuilder();

        colecaoTipo.stream().filter((x) -> (x != null)).forEach((x) -> {
            stringBuilder.append(x.imprimeFichaGUI()).append(System.getProperty("line.separator")); // Método é extendido ao objeto
            stringBuilder.append("----------------------------------------------------------").append(System.getProperty("line.separator"));
        });        
        return stringBuilder;
    }   

}
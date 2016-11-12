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

public class CD extends Mídia{
    protected String artista;
    protected String[] listadeFaixas;
    protected int[] duracao;
    
    public CD(String título, int anoCriação, String artista){
        super(título, anoCriação);
        this.artista = artista;
        this.listadeFaixas = new String[15];
        this.duracao = new int[15];
    }
    
    public void adicionaFaixa(String faixa, int duração){
        int total = this.listadeFaixas.length;
        for(int i = 0; i < total; i++){
            if(i == total - 1 && this.listadeFaixas[i] != null){
                System.out.println("Número máximo de faixas já atingido (total de 15)");
            }
            if(this.listadeFaixas[i] == null) {
                this.listadeFaixas[i] = faixa;
                this.duracao[i] = duração;
                return;
            }                        
        }
    }
    @Override
    public int getTipo(){
        return 1;
    }

    @Override
    public void imprimeFicha(){
        System.out.println("Título: " + this.getTítulo());
        System.out.println("Ano: " + this.getAno());
        System.out.println("Tipo: CD de música");
        System.out.println("Artista: " + this.artista);        
        for(int i = 0; i < this.listadeFaixas.length; i++){
            if(this.listadeFaixas[i] != null) System.out.println("Faixa " + (i+1) + ": " + this.listadeFaixas[i] + ", duração: " + this.duracao[i]);
        }
            
        
    }
    @Override
    public StringBuilder imprimeFichaGUI(){
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Título: ").append(this.getTítulo()).append(System.getProperty("line.separator"));
        
        
        stringBuilder.append("Ano: ").append(this.getAno()).append(System.getProperty("line.separator"));
        stringBuilder.append("Tipo: CD de música").append(System.getProperty("line.separator"));
        stringBuilder.append("Artista: ").append(this.artista).append(System.getProperty("line.separator"));
        for(int i = 0; i < this.listadeFaixas.length; i++){
            if(this.listadeFaixas[i] != null) stringBuilder.append("Faixa ").append(i+1).append(": ").append(this.listadeFaixas[i]).append(", duração: ").append(this.duracao[i]).append(System.getProperty("line.separator"));
        }
        
        return stringBuilder;
            
        
    }
    
}

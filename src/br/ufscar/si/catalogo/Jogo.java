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

public class Jogo extends Mídia{
    protected String genero;

    
    public Jogo(String título, int anoCriação, String genero){
        super(título, anoCriação);
        this.genero = genero;
    }

    @Override
    public int getTipo(){
        return 3;
    }
    @Override
    public void imprimeFicha(){
        System.out.println("Título: " + this.getTítulo());
        System.out.println("Ano: " + this.getAno());
        System.out.println("Tipo: Jogo Eletrônico");
        System.out.println("Gênero: " + this.genero);
    }
    @Override
    public StringBuilder imprimeFichaGUI(){
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Título: ").append(this.getTítulo()).append(System.getProperty("line.separator"));
        stringBuilder.append("Ano: ").append(this.getAno()).append(System.getProperty("line.separator"));
        stringBuilder.append("Tipo: Jogo Eletrônico").append(System.getProperty("line.separator"));
        stringBuilder.append("Gênero: ").append(this.genero).append(System.getProperty("line.separator"));
        return stringBuilder;        
    }
    public String getGenero(){
        return this.genero;
    }
    
}

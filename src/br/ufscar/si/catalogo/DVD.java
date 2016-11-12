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

public class DVD extends Mídia{
    protected String diretor;
    protected String[] atores; 
    protected String[] papel;
    protected int[] duracao;
    
    public DVD(String título, int anoCriação, String diretor){
        super(título, anoCriação);
        this.diretor = diretor;
        this.atores = new String[5];
        this.papel = new String[5];
    }
    
    public void adicionaArtista(String artista, String papel){
        int total = this.atores.length;
        
        for(int i = 0; i < total; i++){
            if(i == total - 1 && this.atores[i] != null){
                System.out.println("Número máximo de atores já atingido (total de 15)");
            }
            if(this.atores[i] == null) {
                this.atores[i] = artista;
                this.papel[i] = papel;
                return;
            }                        
        }
    }
    @Override
    public int getTipo(){
        return 2;
    }
    @Override
    public void imprimeFicha(){
        System.out.println("Título: " + this.getTítulo());
        System.out.println("Ano: " + this.getAno());
        System.out.println("Tipo: Filme em DVD");
        System.out.println("Diretor: " + this.diretor);
        for(int i = 0; i < this.atores.length; i++){
            if(this.atores[i] != null) System.out.println("Artista" + (i+1) + ": " + this.atores[i] + ", papel: " + this.papel[i]);
        }
    }
    @Override
    public StringBuilder imprimeFichaGUI(){
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Título: ").append(this.getTítulo()).append(System.getProperty("line.separator"));
        stringBuilder.append("Ano: ").append(this.getAno()).append(System.getProperty("line.separator"));
        stringBuilder.append("Tipo: Filme em DVD").append(System.getProperty("line.separator"));
        stringBuilder.append("Diretor: ").append(this.diretor).append(System.getProperty("line.separator"));
        for(int i = 0; i < this.atores.length; i++){
            if(this.atores[i] != null) stringBuilder.append("Artista").append(i+1).append(": ").append(this.atores[i]).append(", papel: ").append(this.papel[i]).append(System.getProperty("line.separator"));
        }
        return stringBuilder;        
    }
    
}

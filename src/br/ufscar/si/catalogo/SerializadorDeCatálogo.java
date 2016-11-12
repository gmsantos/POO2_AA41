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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializadorDeCatálogo {

    public void gravaCatálogo(Catálogo catalogo, String arquivo) throws IOException {
        File f = new File(arquivo);
        gravaCatálogo2(catalogo,f);
    }
    
    public void gravaCatálogo2(Catálogo catalogo, File arquivo) throws IOException {
        try (ObjectOutputStream saida = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {
            saida.writeObject(catalogo);
        }
    }

    public void carregaCatálogo(Catálogo catalogo, String arquivo) throws IOException, ClassNotFoundException {
        File f = new File(arquivo);
        carregaCatálogo2(f);
    }

    public Catálogo carregaCatálogo2(File arquivo) throws IOException, ClassNotFoundException{
        Catálogo catalogo;
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(arquivo))) {
            catalogo = (Catálogo) entrada.readObject();
        }
        return catalogo;
    }

    public void main(String[] args) throws IOException, ClassNotFoundException {
       
       File f = new File("dados.dat");
       Catálogo catalogo;
       
       if (f.exists()) {
           catalogo = carregaCatálogo2(f);
       } else {
           catalogo = new Catálogo(0);
       } 
       gravaCatálogo2(catalogo, f);
    }

    Catálogo carregaCatálogo(String testedat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

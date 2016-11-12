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

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Sobre extends javax.swing.JFrame {

    /**
     * Cria novo form
     */
    public Sobre() {
        initComponents();
        StyledDocument doc = jTextPane1.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);      
    }

    //O código à seguir não pode ser editado, por isso não conseguimos inserir comentários
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre Catálogo de Mídias GUI");

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextPane1.setText("\nUFSCAR\n\nSistemas de Informação EAD - G7\n\nNovembro de 2016\n\nPOO2\n\nCatálogo de Mídias GUI\n\nAutores:\n\nGABRIEL MACHADO SANTOS - RA - 581062\n\nJOAO PAULO FRANCELINO MONTEIRO - RA - 545767\n\nDANIEL JOSE CONSTANTINO - RA - 580996 ");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}

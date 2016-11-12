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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListarMidia extends javax.swing.JFrame {

    /**
     * Cria novo form
     */
    public ListarMidia() {
        initComponents();
        
        DBDerby dm = new DBDerby();
        ResultSet rs = dm.retornaTodasMidias();
        jTextArea1.setText(null);
        
        try{
            rs.first();
            do{
                
                jTextArea1.append("Título: " + rs.getString("TITULO") + " \n");
                jTextArea1.append("Ano: " + String.valueOf(rs.getInt("ano"))+ " \n");

                if(rs.getInt("TIPO")== 1){
                    jTextArea1.append("Tipo: CD de música \n");
                    jTextArea1.append("Artista: " + rs.getString("ARTISTA_DIRETOR_GERENERO")+ " \n");
                    ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                    rs2.first();
                    int i = 1;
                    do{
                        jTextArea1.append("Faixa " + String.valueOf(i) + ": " + rs2.getString("FAIXA") + ", duração: " + String.valueOf(rs2.getInt("DURACAO"))+ " \n");
                        i++;

                    }while(rs2.next());

                }
                if(rs.getInt("TIPO")== 2) {
                    jTextArea1.append("Tipo: Filme em DVD \n");
                    jTextArea1.append("Diretor: " + rs.getString("ARTISTA_DIRETOR_GERENERO")+ " \n");
                    ResultSet rs2 = dm.retornaAtoresDVD(rs.getInt("CODIGO"));
                    rs2.first();
                    int i = 1;
                    do{
                        jTextArea1.append("Ator " + String.valueOf(i) + ": " + rs2.getString("ATORES") + ", papel: " + rs2.getString("PAPEL") + " \n");
                        i++;

                    }while(rs2.next());

                }
                if(rs.getInt("TIPO")== 3) jTextArea1.append("Tipo: JOGO \n");
                jTextArea1.append("--------------------------------------------\n");
            }while(rs.next());
            
        }catch (SQLException ex) {
                Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        /*
        if(CatálogoDeMídiasUI.catálogo.catalogo.isEmpty() == false){
            jTextArea1.append(CatálogoDeMídiasUI.catálogo.imprimeColeçãoGUI().toString());
        }
        else jTextArea1.append("Catálogo de Mídias Vazio!!");        
        */
    }

    /**
     * Este trecho do código não pode ser editado, por isso não possui comentários     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista Todas as Mídias");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarMidia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

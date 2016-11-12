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



public class ListarMidiaTipo extends javax.swing.JFrame {

    /**
     * Cria novo form
     */
    public ResultSet rs;
    public DBDerby dm = new DBDerby();
    
    public ListarMidiaTipo() {
        initComponents();
        
        
    }

    /**
     * Este trecho do código não pode ser editado, por isso não possui comentários     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista Mídias por Tipo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CD", "DVD", "Jogo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //
        
        if(jComboBox1.getSelectedItem().equals("CD")){
            try {
                jTextArea1.setText(null);
                rs = dm.retornaMidiasTipo(1);
                rs.first();
                do{
                    
                    jTextArea1.append("Título: " + rs.getString("TITULO") + " \n");
                    jTextArea1.append("Ano: " + String.valueOf(rs.getInt("ano"))+ " \n");

                    jTextArea1.append("Tipo: CD de música \n");
                    jTextArea1.append("Artista: " + rs.getString("ARTISTA_DIRETOR_GERENERO")+ " \n");
                    ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                    rs2.first();
                    int i = 1;
                    do{
                        jTextArea1.append("Faixa " + String.valueOf(i) + ": " + rs2.getString("FAIXA") + ", duração: " + String.valueOf(rs2.getInt("DURACAO"))+ " \n");
                        i++;                                                
                    }while(rs2.next());
                jTextArea1.append("--------------------------------------------\n");
                                
            }while(rs.next());
            
            } catch (SQLException ex) {
                Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(jComboBox1.getSelectedItem().equals("DVD")){
            try {
                jTextArea1.setText(null);
                rs = dm.retornaMidiasTipo(2);
                rs.first();
                do{ 
                    jTextArea1.append("Título: " + rs.getString("TITULO") + " \n");
                    jTextArea1.append("Ano: " + String.valueOf(rs.getInt("ano"))+ " \n");
                    
                    jTextArea1.append("Tipo: Filme em DVD \n");
                    jTextArea1.append("Diretor: " + rs.getString("ARTISTA_DIRETOR_GERENERO")+ " \n");
                    ResultSet rs2 = dm.retornaAtoresDVD(rs.getInt("CODIGO"));
                    rs2.first();
                    int i = 1;
                    do{
                        jTextArea1.append("Ator " + String.valueOf(i) + ": " + rs2.getString("ATORES") + ", papel: " + rs2.getString("PAPEL") + " \n");
                        i++;
                                               
                    }while(rs2.next());
                    jTextArea1.append("--------------------------------------------\n");
                                    
                }while(rs.next());
            
            } catch (SQLException ex) {
                Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(jComboBox1.getSelectedItem().equals("Jogo")){
            try {
                jTextArea1.setText(null);
                rs = dm.retornaMidiasTipo(3);
                rs.first();
                
                do{
                    
                    jTextArea1.append("Título: " + rs.getString("TITULO") + " \n");
                    jTextArea1.append("Ano: " + String.valueOf(rs.getInt("ano"))+ " \n");
                    
                    jTextArea1.append("Tipo: Filme em DVD \n");
                    jTextArea1.append("Gênero: " + rs.getString("ARTISTA_DIRETOR_GERENERO")+ " \n");
                    jTextArea1.append("--------------------------------------------\n");
                               
            }while(rs.next());
            
            } catch (SQLException ex) {
                Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ListarMidiaTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarMidiaTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarMidiaTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarMidiaTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarMidiaTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

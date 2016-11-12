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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExcluiMidia extends javax.swing.JFrame {

    /**
     * Cria novo form
     */
    public int index = 0;
    public Mídia edtMidia;
    public int tamanho = 0;
    public ResultSet rs;
    public DBDerby dm = new DBDerby();
    
    public ExcluiMidia() {
        initComponents();
        
        
        rs = dm.retornaTodasMidias();
        jTextArea1.setText(null);
        
        try {
            rs.first();
            jTextArea1.setText(null);
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
            
            
             
            /*index = 0;
            tamanho = CatálogoDeMídiasUI.catálogo.coleção().size();
            
            edtMidia = CatálogoDeMídiasUI.catálogo.obtemMídia(CatálogoDeMídiasUI.catálogo.coleção().get(index).getTítulo());
            
            if(CatálogoDeMídiasUI.catálogo.catalogo.isEmpty() == false){
            jTextArea1.append(edtMidia.imprimeFichaGUI().toString());
            }
            else jTextArea1.append("Catálogo de Mídias Vazio!!");
            */
            
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Este trecho do código não pode ser editado, por isso não possui comentários     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista Mídias por Tipo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton3.setText("Primeiro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Anterior");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Próximo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Último");
        jButton6.setPreferredSize(new java.awt.Dimension(71, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jButton3)
                    .addGap(53, 53, 53)
                    .addComponent(jButton4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                    .addComponent(jButton5)
                    .addGap(68, 68, 68)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButton1.setText("Exclui");
        jButton1.setMaximumSize(new java.awt.Dimension(71, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(71, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(71, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            rs.first();
            jTextArea1.setText(null);
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
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if(rs.isFirst() == false) rs.previous();
            jTextArea1.setText(null);
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
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if(rs.isLast() == false)rs.next();
            jTextArea1.setText(null);
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
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        try {
            rs.last();
            jTextArea1.setText(null);
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
                    jTextArea1.append("Ator " + String.valueOf(i) + ": " + rs2.getString("ATORES") + ", papel: " + rs2.getString("PAPEL")+ " \n");
                    i++;
                  
                }while(rs2.next());
                
            }
            if(rs.getInt("TIPO")== 3) jTextArea1.append("Tipo: JOGO \n"); 
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //Exclusão de Midia
            if(rs.getInt("Tipo") == 1) dm.ExcluiCD(rs.getInt("CODIGO"));
            if(rs.getInt("Tipo") == 2) dm.ExcluiDVD(rs.getInt("CODIGO"));
            if(rs.getInt("Tipo") == 3) dm.ExcluiJogo(rs.getInt("CODIGO"));
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiMidia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //CatálogoDeMídiasUI.catálogo.catalogo.remove(CatálogoDeMídiasUI.catálogo.catalogo.indexOf(edtMidia));
        this.dispose();
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
            java.util.logging.Logger.getLogger(ExcluiMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluiMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluiMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluiMidia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluiMidia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

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


public class EditaCD extends javax.swing.JFrame {

    /**
     * Cria novo form
     */
  
    public ResultSet rs;
    public DBDerby dm = new DBDerby();
    
    public EditaCD() {
        initComponents();       
        
        rs = dm.retornaMidiasTipo(1);
        try {
            
            if(rs.first()){                
                for(int i = 0; i< 15; i++){
                    tbFaixas.setValueAt(null, i, 0);
                    tbFaixas.setValueAt(null, i, 1);
                }
                
                tfTitulo.setText(rs.getString("TITULO"));
                tfAno.setText(String.valueOf(rs.getInt("ANO")));
                tfArtista.setText(rs.getString("ARTISTA_DIRETOR_GERENERO"));
                
                ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                if(rs2.first()){
                    int i = 0;
                    do{
                        
                            tbFaixas.setValueAt(rs2.getString("FAIXA"), i, 0);
                            tbFaixas.setValueAt(rs2.getInt("DURACAO"), i, 1); 
                            i++;                                               
                    } while(rs2.next());
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este trecho do código não pode ser editado, por isso não possui comentários     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        tfAno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfArtista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFaixas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar CD");

        jButton1.setText("Confirma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Título:");

        tfTitulo.setText("X e Y");

        tfAno.setText("2015");

        jLabel2.setText("Ano:");

        tfArtista.setText("Teste");

        jLabel3.setText("Artista:");

        tbFaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Faixas", "Duração (segundos)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbFaixas);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(tfTitulo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(44, 44, 44)
                        .addComponent(tfAno))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(tfArtista))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(53, 53, 53)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(68, 68, 68)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Implementa o Evento de Clique no Botão confirma
    //Adiciona o CD e suas Faixas
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        CD cd1;
        
        cd1 = new CD(tfTitulo.getText(), Integer.parseInt(tfAno.getText()), tfArtista.getText());
        //Loop para adicionar as faixas cadastradas
        for(int i = 0; i<15; i++)
        {
            Object tit = tbFaixas.getValueAt(i,0);
            Object dur = tbFaixas.getValueAt(i,1);
            if (tit!=null && dur!=null)
            {                
                cd1.adicionaFaixa(tit.toString(),  (Integer)dur);                
            }            
        } 
        //Adiciona o CD ao BD
        DBDerby db = new DBDerby();
        try {
            db.editaCD(rs.getInt("CODIGO"),cd1);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Implementa o Evento de Clique no Botão Cancela
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Fecha a janela sem adicionar o CD
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            
            if(rs.next()){
                for(int i = 0; i< 15; i++){
                    tbFaixas.setValueAt(null, i, 0);
                    tbFaixas.setValueAt(null, i, 1);
                }
                
                tfTitulo.setText(rs.getString("TITULO"));
                tfAno.setText(String.valueOf(rs.getInt("ANO")));
                tfArtista.setText(rs.getString("ARTISTA_DIRETOR_GERENERO"));
                
                ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                if(rs2.first()){
                    int i = 0;
                    do{
                        
                            tbFaixas.setValueAt(rs2.getString("FAIXA"), i, 0);
                            tbFaixas.setValueAt(rs2.getInt("DURACAO"), i, 1); 
                            i++;                                               
                    } while(rs2.next());
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            
            if(rs.last()){
                for(int i = 0; i< 15; i++){
                    tbFaixas.setValueAt(null, i, 0);
                    tbFaixas.setValueAt(null, i, 1);
                }
                tfTitulo.setText(rs.getString("TITULO"));
                tfAno.setText(String.valueOf(rs.getInt("ANO")));
                tfArtista.setText(rs.getString("ARTISTA_DIRETOR_GERENERO"));
                
                ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                if(rs2.first()){
                    int i = 0;
                    do{
                        
                            tbFaixas.setValueAt(rs2.getString("FAIXA"), i, 0);
                            tbFaixas.setValueAt(rs2.getInt("DURACAO"), i, 1); 
                            i++;                                               
                    } while(rs2.next());
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            
            if(rs.previous()){
                for(int i = 0; i< 15; i++){
                    tbFaixas.setValueAt(null, i, 0);
                    tbFaixas.setValueAt(null, i, 1);
                }
                tfTitulo.setText(rs.getString("TITULO"));
                tfAno.setText(String.valueOf(rs.getInt("ANO")));
                tfArtista.setText(rs.getString("ARTISTA_DIRETOR_GERENERO"));
                
                ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                if(rs2.first()){
                    int i = 0;
                    do{
                        
                            tbFaixas.setValueAt(rs2.getString("FAIXA"), i, 0);
                            tbFaixas.setValueAt(rs2.getInt("DURACAO"), i, 1); 
                            i++;                                               
                    } while(rs2.next());
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            
            
            if(rs.first()){
                
                for(int i = 0; i< 15; i++){
                    tbFaixas.setValueAt(null, i, 0);
                    tbFaixas.setValueAt(null, i, 1);
                }
                tfTitulo.setText(rs.getString("TITULO"));
                tfAno.setText(String.valueOf(rs.getInt("ANO")));
                tfArtista.setText(rs.getString("ARTISTA_DIRETOR_GERENERO"));
                
                ResultSet rs2 = dm.retornaFaixasCD(rs.getInt("CODIGO"));
                if(rs2.first()){
                    int i = 0;
                    do{                       
                            tbFaixas.setValueAt(rs2.getString("FAIXA"), i, 0);
                            tbFaixas.setValueAt(rs2.getInt("DURACAO"), i, 1); 
                            i++;                                               
                    } while(rs2.next());
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(EditaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditaCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditaCD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFaixas;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfArtista;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}

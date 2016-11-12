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

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CatálogoDeMídiasUI extends javax.swing.JFrame {

    /**
     * Creates new form CatálogoDeMídiasUI
     */ 
    //Cria um catálogo de Mídias com tamanho máximo de 300
    public static Catálogo catálogo = new Catálogo(300);
    
    public CatálogoDeMídiasUI() {
        initComponents();
        //maximiza a janela principal
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        
    }

    /**
     * Este trecho do código não pode ser editado, por isso não possui comentários     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnCadastro = new javax.swing.JMenu();
        mnCadCD = new javax.swing.JMenuItem();
        mnCadDVD = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnEditar = new javax.swing.JMenu();
        edtCD = new javax.swing.JMenuItem();
        edtDVD = new javax.swing.JMenuItem();
        edtJOGO = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catálogo de Mídas - POO2 - G7 2016");

        jMenu1.setText("Mídias");

        mnCadastro.setText("Cadastro");

        mnCadCD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnCadCD.setText("CD");
        mnCadCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadCDActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadCD);

        mnCadDVD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnCadDVD.setText("DVD");
        mnCadDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadDVDActionPerformed(evt);
            }
        });
        mnCadastro.add(mnCadDVD);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Jogo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnCadastro.add(jMenuItem1);

        jMenu1.add(mnCadastro);

        mnEditar.setText("Editar");

        edtCD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        edtCD.setText("CD");
        edtCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCDActionPerformed(evt);
            }
        });
        mnEditar.add(edtCD);

        edtDVD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        edtDVD.setText("DVD");
        edtDVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDVDActionPerformed(evt);
            }
        });
        mnEditar.add(edtDVD);

        edtJOGO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        edtJOGO.setText("Jogo");
        edtJOGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtJOGOActionPerformed(evt);
            }
        });
        mnEditar.add(edtJOGO);

        jMenu1.add(mnEditar);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Excluir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenu3.setText("Listar");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Lista Todas as Mídias");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Listar Mídia Por Tipo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenu1.add(jMenu3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Buscar Mídia");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator2);
        jMenu1.add(jSeparator1);

        jMenuItem8.setText("Cria BD e tabelas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Carregar Valores de Mídias Padrões");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Sobre");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadCDActionPerformed
        //Chama o Formulário para cadastro de CD
        new CadastroCD().setVisible(true);
    }//GEN-LAST:event_mnCadCDActionPerformed

    private void mnCadDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadDVDActionPerformed
        //Chama o Formulário para cadastro de DVD
        new CadastroDVD().setVisible(true);
    }//GEN-LAST:event_mnCadDVDActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Chama o Formulário para cadastro de Jogo
        new CadastroJOGO().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //Preenche BD com dados padrão
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        DBDerby db = new DBDerby();
        
        db.AlimentaTabelas();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //Chama o Formulário que lista todas as Mídias
        new ListarMidia().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //Chama o Formulário que lista de Mídias por Tipo
        new ListarMidiaTipo().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //Chama o Formulário de busca de Mídias
        new BuscarMidia().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void edtCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCDActionPerformed
        //Chama o Formulário de edição de CDs
        new EditaCD().setVisible(true);
    }//GEN-LAST:event_edtCDActionPerformed

    private void edtDVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDVDActionPerformed
        //Chama o Formulário de edição de DVDs
        new EditaDVD().setVisible(true);
    }//GEN-LAST:event_edtDVDActionPerformed

    private void edtJOGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtJOGOActionPerformed
        //Chama o Formulário de edição de Jogos
        new EditaJogo().setVisible(true);
    }//GEN-LAST:event_edtJOGOActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //Chama o Formulário de exclusão de Midias
        new ExcluiMidia().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Chama o Formulário de exclusão de Midias
        new Sobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    //Cria BD e tableas
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DBDerby db = new DBDerby();
        
        try {
            db.CriaTabelas();
        } catch (SQLException ex) {
            Logger.getLogger(CatálogoDeMídiasUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    
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
            java.util.logging.Logger.getLogger(CatálogoDeMídiasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatálogoDeMídiasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatálogoDeMídiasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatálogoDeMídiasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatálogoDeMídiasUI().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem edtCD;
    private javax.swing.JMenuItem edtDVD;
    private javax.swing.JMenuItem edtJOGO;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem mnCadCD;
    private javax.swing.JMenuItem mnCadDVD;
    private javax.swing.JMenu mnCadastro;
    private javax.swing.JMenu mnEditar;
    // End of variables declaration//GEN-END:variables
}

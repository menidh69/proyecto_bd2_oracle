/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanaUser3;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Alondra
 */
public class tablas extends javax.swing.JFrame {
        private final String USER = "postgres";
    private final String PASS = "contrasena";
    final private Database db;
    private final HashMap ht;
    
    public tablas() {
        db = Database.getDatabase();
        initComponents();
        this.setSize(800, 600);
        
        ht = new HashMap<String, Integer>();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        tipodato1 = new javax.swing.JComboBox();
        tipodato2 = new javax.swing.JComboBox();
        txtcolumna1 = new javax.swing.JTextField();
        tipodato3 = new javax.swing.JComboBox();
        txtcolumna2 = new javax.swing.JTextField();
        tipodato4 = new javax.swing.JComboBox();
        txtcolumna3 = new javax.swing.JTextField();
        btguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcolumna = new javax.swing.JTextField();
        tipodato = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtcolumna4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("DATA NAME");

        tipodato1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tipodato1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "CHAR(20)", "VARCHAR(50)", "DATE" }));
        tipodato1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipodato1ActionPerformed(evt);
            }
        });

        tipodato2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tipodato2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "CHAR(20)", "VARCHAR(50)", "DATE" }));
        tipodato2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipodato2ActionPerformed(evt);
            }
        });

        txtcolumna1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcolumna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolumna1ActionPerformed(evt);
            }
        });

        tipodato3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tipodato3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "CHAR(20)", "VARCHAR(50)", "DATE" }));
        tipodato3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipodato3ActionPerformed(evt);
            }
        });

        txtcolumna2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcolumna2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolumna2ActionPerformed(evt);
            }
        });

        tipodato4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tipodato4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "CHAR(20)", "VARCHAR(50)", "DATE" }));
        tipodato4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipodato4ActionPerformed(evt);
            }
        });

        txtcolumna3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcolumna3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolumna3ActionPerformed(evt);
            }
        });

        btguardar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btguardar.setText("SAVE");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("TABLE NAME");
        jLabel1.setToolTipText("");

        txtnombre.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("DATA NAME");

        txtcolumna.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcolumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolumnaActionPerformed(evt);
            }
        });

        tipodato.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tipodato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "CHAR(20)", "VARCHAR(50)", "DATE" }));
        tipodato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipodatoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("DATATYPE");

        txtcolumna4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcolumna4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolumna4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("DATA NAME");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("DATA NAME");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("DATA NAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(txtcolumna)
                    .addComponent(txtnombre)
                    .addComponent(txtcolumna1)
                    .addComponent(txtcolumna2)
                    .addComponent(txtcolumna3)
                    .addComponent(txtcolumna4, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipodato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipodato1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipodato2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipodato3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipodato4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tipodato, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcolumna, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolumna1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipodato1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolumna2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipodato2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolumna3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipodato3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcolumna4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipodato4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipodato1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipodato1ActionPerformed
        String tipodedato1=(String)tipodato1.getSelectedItem();
    }//GEN-LAST:event_tipodato1ActionPerformed

    private void tipodato2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipodato2ActionPerformed
        String tipodedato2=(String)tipodato2.getSelectedItem();
    }//GEN-LAST:event_tipodato2ActionPerformed

    private void txtcolumna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolumna1ActionPerformed
        String texto = txtcolumna1.getText();
    }//GEN-LAST:event_txtcolumna1ActionPerformed

    private void tipodato3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipodato3ActionPerformed
        String tipodedato3=(String)tipodato3.getSelectedItem();
    }//GEN-LAST:event_tipodato3ActionPerformed

    private void txtcolumna2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolumna2ActionPerformed
        String texto = txtcolumna2.getText();
    }//GEN-LAST:event_txtcolumna2ActionPerformed

    private void tipodato4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipodato4ActionPerformed
        String tipodedato4=(String)tipodato4.getSelectedItem();
    }//GEN-LAST:event_tipodato4ActionPerformed

    private void txtcolumna3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolumna3ActionPerformed
        String texto = txtcolumna3.getText();
    }//GEN-LAST:event_txtcolumna3ActionPerformed

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        String tablename = txtnombre.getText();
        String dataname = txtcolumna.getText();
        String dataname1 = txtcolumna1.getText();
        String dataname2 = txtcolumna2.getText();
        String dataname3 = txtcolumna3.getText();
        String dataname4 = txtcolumna4.getText();
        String tipodedato=(String)tipodato.getSelectedItem();
        String tipodedato1=(String)tipodato1.getSelectedItem();
        String tipodedato2=(String)tipodato2.getSelectedItem();
        String tipodedato3=(String)tipodato3.getSelectedItem();
        String tipodedato4=(String)tipodato4.getSelectedItem();
        
        
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tablename + " (" + dataname + " " + tipodedato + " NOT NULL, " + dataname1 +  " " + tipodedato1 +
            " NOT NULL, " + dataname2 +  " " + tipodedato2 + " NOT NULL, " + dataname3 + " " + tipodedato3 + " NOT NULL, " + dataname4 +  " " + tipodedato4 + " NOT NULL," + " PRIMARY KEY"
            + " (" + dataname + "));");
        System.out.println( sql.toString() );

        try {
            db.update( sql.toString() );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear tabla.");
            System.out.println( ex.getMessage() );
        }
        setVisible(true);
    }//GEN-LAST:event_btguardarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        String text = txtnombre.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introducir el nombre de la tabla.");
        }
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtcolumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolumnaActionPerformed
        String texto = txtcolumna.getText();
    }//GEN-LAST:event_txtcolumnaActionPerformed

    private void tipodatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipodatoActionPerformed
        String tipodedato=(String)tipodato.getSelectedItem();
    }//GEN-LAST:event_tipodatoActionPerformed

    private void txtcolumna4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolumna4ActionPerformed
        String texto = txtcolumna4.getText();
    }//GEN-LAST:event_txtcolumna4ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox tipodato;
    private javax.swing.JComboBox tipodato1;
    private javax.swing.JComboBox tipodato2;
    private javax.swing.JComboBox tipodato3;
    private javax.swing.JComboBox tipodato4;
    private javax.swing.JTextField txtcolumna;
    private javax.swing.JTextField txtcolumna1;
    private javax.swing.JTextField txtcolumna2;
    private javax.swing.JTextField txtcolumna3;
    private javax.swing.JTextField txtcolumna4;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
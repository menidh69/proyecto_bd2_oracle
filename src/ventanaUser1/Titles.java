/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanaUser1;
import Conection.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanaUser2.ventanaUser2;
/**
 *
 * @author dell
 */
public class Titles extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    static DefaultTableModel modelo;
    String title;
    
    public String getTitle_name(){
        return title;
    }
    public void setTitle_name(String title){
        this.title = title;
        
    }
    static String user;
    public Titles(String user) {
        initComponents();
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Empleados");
        
        this.user = user;
        
        
    }
    
    public void mostrarTabla(DefaultTableModel modelo, String consulta) {
  modelo.setRowCount(0);
  Conexion conn = new Conexion();
    
  Connection c = conn.miconexion();
  if (c != null) {
   try {
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(consulta);

    while(rs.next()) {
     Object[] tablaSQL = new Object[6];

     for(int i=0; i<=modelo.getColumnCount()-1; i++) {
     tablaSQL[i] = rs.getObject(i+1);
    }

    modelo.addRow(tablaSQL);
   }
   c.close();
   } catch(SQLException se) {
    JOptionPane.showMessageDialog(null, se);
   }
  }
 }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        seniorstaff = new javax.swing.JButton();
        seniorengineer = new javax.swing.JButton();
        Staff = new javax.swing.JButton();
        assistengineer = new javax.swing.JButton();
        manager = new javax.swing.JButton();
        techLeader = new javax.swing.JButton();
        engineer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Search by: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "emp_no", "birth_date", "first_name", "last_name", "gender", "hire_date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane3.setViewportView(jTextPane1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "emp_no", "birth_date", "first_name", "last_name", "gender   ", "hire_date" }));

        seniorstaff.setText("Senior Staff");
        seniorstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seniorstaffActionPerformed(evt);
            }
        });

        seniorengineer.setText("Senior Engineer");
        seniorengineer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seniorengineerActionPerformed(evt);
            }
        });

        Staff.setText("Staff");
        Staff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaffActionPerformed(evt);
            }
        });

        assistengineer.setText("Assistant Engineer");
        assistengineer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assistengineerActionPerformed(evt);
            }
        });

        manager.setText("Manager");
        manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerActionPerformed(evt);
            }
        });

        techLeader.setText("Technique Leader");
        techLeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techLeaderActionPerformed(evt);
            }
        });

        engineer.setText("Engineer");
        engineer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engineerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel2.setText("Employees");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Titles");

        jMenu1.setText("Regresar");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(103, 103, 103))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Staff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(engineer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(manager, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assistengineer, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(seniorstaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(techLeader, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(86, 86, 86)
                        .addComponent(seniorengineer, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Staff)
                    .addComponent(assistengineer)
                    .addComponent(seniorengineer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manager)
                    .addComponent(techLeader))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(engineer)
                    .addComponent(seniorstaff))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
           // TODO add your handling code here:
          
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        switch (user){
                case "user1":
                    new ventanaUser1().setVisible(true);
                    this.setVisible(false);
                    break;
                case "user2":
                    new ventanaUser2().setVisible(true);
                    this.setVisible(false);
                    break;
                case "user3":
                    break;
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void assistengineerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assistengineerActionPerformed
        setTitle_name("Assistant Engineer");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_assistengineerActionPerformed

    private void seniorengineerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seniorengineerActionPerformed
        setTitle_name("Senio Engineer");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_seniorengineerActionPerformed

    private void seniorstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seniorstaffActionPerformed
        setTitle_name("Senior Staff");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_seniorstaffActionPerformed

    private void techLeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techLeaderActionPerformed
        setTitle_name("Technique Leader");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_techLeaderActionPerformed

    private void engineerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engineerActionPerformed
        setTitle_name("Engineer");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_engineerActionPerformed

    private void managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerActionPerformed
        setTitle_name("Manager");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_managerActionPerformed

    private void StaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaffActionPerformed
       setTitle_name("Staff");
        llenarTabla(title,1000, false);
    }//GEN-LAST:event_StaffActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextPane1.getText().equalsIgnoreCase("")){
            
        }else{
            
            llenarTabla(title,1000, true);
        };
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Titles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Titles(user).setVisible(true);
            }
        });
        
    }
    public void llenarTabla(String title, int rows, boolean search) {
        DefaultTableModel modelo = new DefaultTableModel();
        String query;
        if(search){
            if(jComboBox1.getSelectedItem().toString().equals("emp_no")){
                query = "SELECT meni.employees.emp_no, meni.titles.title, meni.employees.birth_date, meni.employees.first_name, meni.employees.last_name, meni.employees.gender, meni.employees.hire_date FROM meni.employees INNER JOIN meni.titles ON meni.employees.emp_no = meni.titles.emp_no "
                +" WHERE meni.departments.dept_name = '"+title+"' AND ROWNUM <= 1000 AND meni.employees."+jComboBox1.getSelectedItem().toString()+" = "+jTextPane1.getText().toString()+"";
            }else{
                query = "SELECT meni.employees.emp_no, meni.employees.birth_date, meni.employees.first_name, meni.employees.last_name, meni.employees.gender, meni.employees.hire_date FROM meni.employees INNER JOIN meni.dept_emp ON meni.employees.emp_no = meni.dept_emp.emp_no "
                + "INNER JOIN meni.departments ON meni.dept_emp.dept_no = meni.departments.dept_no WHERE meni.departments.dept_name = '"+title+"' AND ROWNUM <= 1000 AND meni.employees."+jComboBox1.getSelectedItem().toString()+" = '"+jTextPane1.getText().toString()+"'";
            }
        }
            else{
                    query="SELECT meni.employees.emp_no, meni.titles.title, meni.employees.birth_date, meni.employees.first_name, meni.employees.last_name, meni.employees.gender, meni.employees.hire_date FROM meni.employees INNER JOIN meni.titles ON meni.employees.emp_no = meni.titles.emp_no "
                + "WHERE meni.titles.title = '"+title+"' AND ROWNUM <= 1000";
                    }
            
            ResultSet rs = Conexion.getTable(query);
        modelo.setColumnIdentifiers(new Object[]{"Employee id", "title", "Birth date", "Firstname", "Lastname", "Gender", "hire date"});
        try {
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("emp_no"), rs.getString("title"), rs.getDate("birth_date"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), rs.getDate("hire_date")});
            }
            jTable1.setModel(modelo);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Staff;
    private javax.swing.JButton assistengineer;
    private javax.swing.JButton engineer;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton manager;
    private javax.swing.JButton seniorengineer;
    private javax.swing.JButton seniorstaff;
    private javax.swing.JButton techLeader;
    // End of variables declaration//GEN-END:variables
}

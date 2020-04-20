package CRUD_Classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author propietario
 */
public class Departments {
    JFrame v1 = new JFrame();
    final String queryApt_id = "SELECT dept_no FROM meni.departments ORDER BY dept_no";
    final String llave1 = "dept_no";
    
    String dept_no;
    String dept_name;
    static DefaultTableModel modelo;
 static JTable tabla1;
    
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    
    public Departments(){
        this.v1 = v1;
    }
    
    public void show() throws SQLException{
    JDialog v = new JDialog(v1, "Departments");
    
    JLabel label1 = new JLabel("dept_no");
    JLabel label2 = new JLabel("dept_name");
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    
    button.setBounds(140, 500, 120, 30);
    
    QueryLastID ql = new QueryLastID();
    ql.setNewID(queryApt_id, llave1);
    field1.setText(ql.getNewID());
    field1.setEnabled(false);
    String id = field1.getText();
    
    field1.setText(id);
     
    
    
    
    
     field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
     ActionListener listener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button){
                
                if (field2.getText().equals(""))  {
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    int dato1 = Integer.parseInt(id);
                   
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                     st.executeUpdate("INSERT INTO meni.departments VALUES "+ field1.getText()
                             +",\""+field2.getText() + "\");");
                    c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    field2.setText("");
                    
                    
//                    field8.setText("");
                     } catch(SQLException se10) {
                    JOptionPane.showMessageDialog(null, se10);
                    }
                     
                }
                
                
                
                
                
                
            }
        }
        }
    };
        
    
    v.add(label1);
    v.add(label2);
    v.add(field1);
    v.add(field2);
    v.add(button);
    
    button.addActionListener(listener);


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);

       
  
        
        }
    
     public void update(int linea, JTable tabla1) throws SQLException{
     JDialog v = new JDialog(v1, "Departments");
    
    JLabel label1 = new JLabel("dept_no");
    JLabel label2 = new JLabel("dept_name");
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    
    button.setBounds(140, 500, 120, 30);
     field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
    
    field1.setText(tabla1.getValueAt(linea,0).toString());
    field2.setText(tabla1.getValueAt(linea, 1).toString());
    
    ActionListener listener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button){
                
                if (field2.getText().equals(""))  {
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                   
                   
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                     st.executeUpdate("UPDATE meni.departments SET "+label2.getText()+"\"= \""+field2.getText()+"\");");
                    c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    field2.setText("");
                    
                    
//                    field8.setText("");
                     } catch(SQLException se10) {
                    JOptionPane.showMessageDialog(null, se10);
                    }
                     
                }
                
                
                
                
                
                
            }
        }
        }
    };
     }
    }
    


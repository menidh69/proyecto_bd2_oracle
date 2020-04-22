package CRUD_Classes;


import Conection.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class Department_man {
    
    
    final String queryApt_id = "SELECT emp_no FROM meni.employees ORDER BY emp_no";
    final String llave1 = "emp_no";
    final String building = "SELECT dept_no FROM meni.departments ORDER BY dept_no";
    final String llave2 = "dept_no";
    String from_date;
    String to_date;
    JButton field3 = new JButton("Seleccionar fecha");
    JButton field4 = new JButton("Seleccionar fecha");
    
    JComboBox<String> field2 = new JComboBox<>();
     
     JFrame v1 = new JFrame();
     static DefaultTableModel modelo;
     static JTable tabla1;
     public Department_man(JFrame v1){
         this.v1 = v1;
     }
     
     public void show(boolean manager) throws SQLException{
         String text;
        if(manager){
            text = "Department manager";
        }else{
            text = "Department employee";
        }
    JDialog v = new JDialog(v1, text);
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("dept_no");
    JLabel label3 = new JLabel("from_date");
    JLabel label4 = new JLabel("to_date");
   
    
    
    
    
    
    JTextField field1 = new JTextField();
    
    
   
    
    
    QueryComboClass qcc = new QueryComboClass();
    qcc.prueba(building, llave2);
    field2 = qcc.GetQueryCombo();
    
    
    
    
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    label3.setBounds(20, 160, 150, 20);
    label4.setBounds(20, 220, 150, 20);
   
    
    field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
    field3.setBounds(200, 160, 150, 20);
    field4.setBounds(200, 220, 150, 20);
   
    
    
    button.setBounds(140, 520, 120, 30);
    
    ActionListener listener = new ActionListener(){
     @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==field3){
                JPanel p = new JPanel();
        
		final JFrame f = new JFrame();
                f.setLocationRelativeTo(field3);
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
                field3.setText(new DatePicker(f).setPickedDate());
                               
                                f.dispose();
		
            }
            if (e.getSource()==field4){
                JPanel p = new JPanel();
        
		final JFrame f = new JFrame();
                f.setLocationRelativeTo(field3);
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
                field3.setText(new DatePicker(f).setPickedDate());
                               
                                f.dispose();
            }
            if (e.getSource()== button){
                if ( field4.getText().equals("")){
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

                } else if (field4.getText().length()>10){
                    JOptionPane.showMessageDialog(null, label4.getText() + " debe tener menos de 10 caracteres");
                }
                
                
                
                
                
               else{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    int id = Integer.parseInt(field1.getText());
                    String id_dept = field2.getSelectedItem().toString();
                    String fecha1 = field3.getText();
                    String fecha2 = field4.getText();
                    
                    LocalDate localDate = LocalDate.parse(fecha1, formatter);
                    LocalDate localDate2 = LocalDate.parse(fecha2, formatter);
                    java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
                    java.sql.Date sqlDate2 = java.sql.Date.valueOf( localDate2 );
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    
                    
      
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                    PreparedStatement p;
                    if(manager){
                    p = c.prepareStatement("INSERT INTO meni.dept_manager VALUES(?,?,?,?)");
                    }else{
                     p = c.prepareStatement("INSERT INTO meni.dept_emp VALUES(?,?,?,?)");
                    }
                    p.setInt(1, id);
                      p.setString(2, id_dept);
                      p.setDate(3, sqlDate);
                      p.setDate(4, sqlDate2);
                    
                     p.executeUpdate();
                    
                        
                    
                    c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    field1.setText("");
                    
                    field2.setSelectedIndex(1);
                    field3.setText("");
                    field4.setText("");
                    
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
    v.add(label3);
    v.add(label4);
   
    
    v.add(field1);
    v.add(field2);
    v.add(field3);
    v.add(field4);
   
    
    v.add(button);
    button.addActionListener(listener);
    field3.addActionListener(listener);
    field4.addActionListener(listener);


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);
    
            }
    
    
    public void update(int linea, JTable tabla1, boolean manager) throws SQLException{
        String text;
        if(manager){
            text = "Department manager";
        }else{
            text = "Department employee";
        }
       JDialog v = new JDialog(v1, text);
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("dept_no");
    JLabel label3 = new JLabel("from_date");
    JLabel label4 = new JLabel("to_date");
    
    JTextField field1 = new JTextField();
   
   
   // field1 = q1.GetQueryCombo();
    
    
    QueryComboClass qcc = new QueryComboClass();
    qcc.prueba(building, llave2);
    field2 = qcc.GetQueryCombo();
    
    
    
    
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    label3.setBounds(20, 160, 150, 20);
    label4.setBounds(20, 220, 150, 20);
   
    
    field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
    field3.setBounds(200, 160, 150, 20);
    field4.setBounds(200, 220, 150, 20);
    
    button.setBounds(140, 520, 120, 30);
    
    field1.setText(tabla1.getValueAt(linea,0).toString());
    field2.setSelectedItem(tabla1.getValueAt(linea, 1).toString());
    field3.setText(tabla1.getValueAt(linea, 2).toString());
    field4.setText(tabla1.getValueAt(linea, 3).toString());
    
    
    button.setBounds(140, 520, 120, 30);
    
    ActionListener listener = new ActionListener(){
     @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== button){
                if ( field4.getText().equals("")){
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

                } else if (field4.getText().length()>10){
                    JOptionPane.showMessageDialog(null, label4.getText() + " debe tener menos de 10 caracteres");
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    int id = Integer.parseInt(field1.getText());
                    String id_dept = field2.getSelectedItem().toString();
                    String fecha1 = field3.getText();
                    String fecha2 = field4.getText();
                    
                    LocalDate localDate = LocalDate.parse(fecha1, formatter);
                    LocalDate localDate2 = LocalDate.parse(fecha2, formatter);
                    java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
                    java.sql.Date sqlDate2 = java.sql.Date.valueOf( localDate2 );
                    
      
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                    PreparedStatement p;
                    if(manager){
                    p = c.prepareStatement("UPDATE meni.dept_manager SET emp_no = ?, dept_no = ?, from_date = ?, to_date = ?");
                    }else{
                     p = c.prepareStatement("UPDATE meni.dept_emp SET emp_no = ?, dept_no = ?, from_date = ?, to_date = ?");
                    }
                      p.setInt(1, id);
                      p.setString(2, id_dept);
                      p.setDate(3, sqlDate);
                      p.setDate(4, sqlDate2);
                    
                     p.executeUpdate();
                   // p.executeUpdate("UPDATE meni.dept_manager SET "+label1.getText()+"="+field1.getText().toString()+","+label2.getText()+"="+field2.getSelectedItem().toString()+", "+ label3.getText() 
                    //         + "="+field3.getText().toString()+", " + label4.getText() + "="+field4.getText().toString()+";");
                     c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    
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
    v.add(label3);
    v.add(label4);
   
    
    v.add(field1);
    v.add(field2);
    v.add(field3);
    v.add(field4);
 
    
    v.add(button);
    button.addActionListener(listener);
    field3.addActionListener(listener);
    field4.addActionListener(listener);


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);
    
            
    }
}


package CRUD_Classes;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Salary {
     
    final String query = "SELECT emp_no FROM meni.salaries ORDER BY emp_no";
    final String llave1 = "emp_no";
    String title;
    String from_date;
    String to_date;
    JButton field3 = new JButton("Seleccionar fecha");
    JButton field4 = new JButton("Seleccionar fecha");
    
    JTextField field2 = new JTextField();
     JComboBox<String> field1 = new JComboBox<>();
     JFrame v1 = new JFrame();
     static DefaultTableModel modelo;
     static JTable tabla1;
     public Salary(JFrame v1){
         this.v1 = v1;
     }
     
     public void show() throws SQLException{
    JDialog v = new JDialog(v1, "Apartments");
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("salary");
    JLabel label3 = new JLabel("from_date");
    JLabel label4 = new JLabel("to_date");
   
    
    
    
    
    
    
    
    
    QueryComboClass q1 = new QueryComboClass();
    q1.prueba(query, llave1);
    field1 = q1.GetQueryCombo();
    
    
    
    
    
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
                JLabel label = new JLabel("Selected Date:");
		final JTextField text = new JTextField(20);
		JButton b = new JButton("popup");
		JPanel p = new JPanel();
		p.add(label);
		p.add(text);
		p.add(b);
		final JFrame f = new JFrame();
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new DatePicker(f).setPickedDate());
                                from_date = text.getText();
                                field3.setText(from_date.toString());
                                f.dispose();
			}
		});
            }
            if (e.getSource()==field4){
                 JLabel label = new JLabel("Selected Date:");
		final JTextField text = new JTextField(20);
		JButton b = new JButton("popup");
		JPanel p = new JPanel();
		p.add(label);
		p.add(text);
		p.add(b);
		final JFrame f = new JFrame();
		f.getContentPane().add(p);
		f.pack();
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				text.setText(new DatePicker(f).setPickedDate());
                                to_date = text.getText();
                                field4.setText(to_date);
                                f.dispose();
			}
		});
            }
            if (e.getSource()== button){
                if ( field4.getText().equals("")){
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

                } else if (field4.getText().length()>10){
                    JOptionPane.showMessageDialog(null, label4.getText() + " debe tener menos de 10 caracteres");
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    int dato1 = Integer.parseInt(field1.getSelectedItem().toString());
                    
      
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                     st.executeUpdate("INSERT INTO meni.salaries ("+label1.getText()+","+label2.getText()+","+ label3.getText() 
                             + "," + label4.getText() +"');");
                    c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    field1.setSelectedIndex(1);
                    
                    field2.setText("");
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
    


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);
    
            }
    
    
    public void update(int linea, JTable tabla1) throws SQLException{
       JDialog v = new JDialog(v1, "Apartments");
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("salaries");
    JLabel label3 = new JLabel("from_date");
    JLabel label4 = new JLabel("to_date");
    
    
   
     QueryComboClass q1 = new QueryComboClass();
    q1.prueba(query, llave1);
    field1 = q1.GetQueryCombo();
    
    
    
    
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
    
    field1.setSelectedItem(tabla1.getValueAt(linea,0).toString());
    field2.setText(tabla1.getValueAt(linea, 1).toString());
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
                    
                    
      
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                    st.executeUpdate("UPDATE meni.salaries SET "+label1.getText()+"="+field1.getSelectedItem().toString()+","+label2.getText()+"="+field2.getText()+", "+ label3.getText() 
                             + "="+field3.getText().toString()+", " + label4.getText() + "="+field4.getText().toString()+";");
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
    


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);
    
            
    }
}

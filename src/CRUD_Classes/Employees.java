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
public class Employees {
    
    JFrame v1 = new JFrame();
    final String queryApt_id = "SELECT emp_no FROM employees ORDER BY emp_no";
    final String llave1 = "emp_no";
    
    String birth_date;
    String first_name;
    String last_name;
    String gender;
    String hire_date;
    
    static DefaultTableModel modelo;
 static JTable tabla1;
    
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    JComboBox<String> field5 = new JComboBox<>();
    JTextField field1 = new JTextField();
    JButton field2 = new JButton("Seleccionar fecha");
    JButton field6 = new JButton("Seleccionar fecha");
    
    public Employees(JFrame v1) {
    this.v1 = v1;
    field5.addItem("Escoger sexo");
    field5.addItem("M");
    field5.addItem("F");
    
}
    
    public void show() throws SQLException{
    JDialog v = new JDialog(v1, "Apartment Bookings");
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("birth_date");
    JLabel label3 = new JLabel("first_name");
    JLabel label4 = new JLabel("last_name");
    JLabel label5 = new JLabel("gender");
    JLabel label6 = new JLabel("hire_date");
    
//    JLabel label8 = new JLabel("other_building" );
//    JLabel label9 = new JLabel("details" );   
    
//    JTextField field8 = new JTextField();
    
    
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    label3.setBounds(20, 160, 150, 20);
    label4.setBounds(20, 220, 150, 20);
    label5.setBounds(20, 280, 150, 20);
    label6.setBounds(20, 340, 150, 20);
   
//    label8.setBounds(20, 460, 150, 20);
//        label9.setBounds(20, 480, 150, 20);

    
   
    
//    field8.setBounds(200, 460, 150, 20);
    
    button.setBounds(140, 500, 120, 30);
    
    QueryLastID ql = new QueryLastID();
    ql.setNewID(queryApt_id, llave1);
    field1.setText(ql.getNewID());
    field1.setEnabled(false);
    String id = field1.getText();
    
    field1.setText(id);
     
    
    
    
    
     field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
    field3.setBounds(200, 160, 150, 20);
    field4.setBounds(200, 220, 150, 20);
    field5.setBounds(200, 280, 150, 20);
    field6.setBounds(200, 340, 150, 20);
    
    
    ActionListener listener = new ActionListener(){
     @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==field2){
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
                                birth_date = text.getText();
                                field2.setText(birth_date.toString());
                                f.dispose();
			}
		});
            }
            if (e.getSource()==field6){
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
                                hire_date = text.getText();
                                field6.setText(hire_date);
                                f.dispose();
			}
		});
            }
            if (e.getSource()== button){
                
                if (
                        field2.getText().equals("Seleccionar fecha")   || field6.getText().equals("Seleccionar fecha")   || field6.getText().equals("")   
                          ){
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

                }else if (field3.getText().length()>255){
                    JOptionPane.showMessageDialog(null, label5.getText() + " debe tener menos de 255 caracteres");
                }else if (field4.getText().length()>255){
                    JOptionPane.showMessageDialog(null, label6.getText() + " debe tener menos de 255 caracteres");
                }else if (field5.getSelectedItem().equals("Escoger sexo")){
                    JOptionPane.showMessageDialog(null, label5.getText() + " debe escoger un sexo");
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    int dato1 = Integer.parseInt(id);
                   
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                     st.executeUpdate("INSERT INTO employees VALUES("+ field1.getText()
                             +",\""+field2.getText().toString() + "\",\"" + field3.getText().toString() + "\",\"" + field4.getText().toString() + "\",\"" + field5.getSelectedItem().toString()+ "\",\"" +
                                      field6.getText() +"\");");
                    c.close();
                    JOptionPane.showMessageDialog(null, "Dato agregado correctamente xD");
                    field2.setText("Seleccionar fecha");
                    field3.setText("");
                    field4.setText("");
                    field5.setSelectedIndex(1);
                    field6.setText("Seleccionar fecha");
                    
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
    v.add(label3);
    v.add(label4);
    v.add(label5);
    v.add(label6);
   
//    v.add(label8);
//    v.add(label9);
    
    v.add(field1);
    v.add(field2);
    v.add(field3);
    v.add(field4);
    v.add(field5);
    v.add(field6);
    
//    v.add(field8);
    
    v.add(button);
    field5.addActionListener(listener);
    field6.addActionListener(listener);
    button.addActionListener(listener);


    
    v.setLayout(null);
  v.setResizable(false);
  v.setSize(400,600);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.DISPOSE_ON_CLOSE);
  v.setVisible(true);

       
  
    
            }
    
    public void update(int linea, JTable tabla1) throws SQLException{
        
        JDialog v4 = new JDialog(v1, "Apartment Bookings");
    
    JLabel label1 = new JLabel("emp_no");
    JLabel label2 = new JLabel("birth_date");
    JLabel label3 = new JLabel("first_name");
    JLabel label4 = new JLabel("last_name");
    JLabel label5 = new JLabel("gender");
    JLabel label6 = new JLabel("hire_date");
    
   

   
    JTextField field1 = new JTextField();
    
    

    
    
    JButton button = new JButton ("Guardar");
    
    label1.setBounds(20, 40, 150, 20);
    label2.setBounds(20, 100, 150, 20);
    label3.setBounds(20, 160, 150, 20);
    label4.setBounds(20, 220, 150, 20);
    label5.setBounds(20, 280, 150, 20);
    label6.setBounds(20, 340, 150, 20);
    
//    label8.setBounds(20, 460, 150, 20);
//        label9.setBounds(20, 480, 150, 20);

    
    field1.setBounds(200, 40, 150, 20);
    field2.setBounds(200, 100, 150, 20);
    field3.setBounds(200, 160, 150, 20);
    field4.setBounds(200, 220, 150, 20);
    field5.setBounds(200, 280, 150, 20);
    field6.setBounds(200, 340, 150, 20);
    
//    field8.setBounds(200, 460, 150, 20);


    field1.setText(tabla1.getValueAt(linea,0).toString());
    field2.setText(tabla1.getValueAt(linea, 1).toString());
    field3.setText(tabla1.getValueAt(linea, 2).toString());
    field4.setText(tabla1.getValueAt(linea, 3).toString());
    field5.setSelectedItem(tabla1.getValueAt(linea, 4).toString());
    field6.setText(tabla1.getValueAt(linea, 5).toString());
    
    
    button.setBounds(140, 500, 120, 30);
    
    field1.setEnabled(false);
    

    ActionListener listener = new ActionListener(){
     @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==field5){
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
                                birth_date = text.getText();
                                field6.setText(birth_date);
                                f.dispose();
			}
		});
            }
            if (e.getSource()==field6){
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
                                hire_date = text.getText();
                                field6.setText(hire_date);
                                f.dispose();
			}
		});
            }
            if (e.getSource()== button){
                
                if (
                        field2.getText().equals("Seleccionar fecha")   || field6.getText().equals("Seleccionar fecha")  ){
                          JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

                }else if (field3.getText().length()>255){
                    JOptionPane.showMessageDialog(null, label5.getText() + " debe tener menos de 255 caracteres");
                }else if (field4.getText().length()>50){
                    JOptionPane.showMessageDialog(null, label6.getText() + " debe tener menos de 50 caracteres");
                }else if (field5.getSelectedItem().toString()==("Escoge sexo")){
                    JOptionPane.showMessageDialog(null, label5.getText() + " debe tener menos de 80 caracteres");
                }
                
                
                
                
                
               else{
                    Conexion con = new Conexion();
                    Connection c = con.miconexion();
                    
                   
                    if (c != null) {
                    

                    try {
                    Statement st = c.createStatement();
                           st.executeUpdate("UPDATE \"Apartment_Bookings\" SET "+label2.getText()+"="+field2.getText().toString()+", "+ label3.getText() 
                             + "="+field3.getText().toString()+", " + label4.getText() + "="+field4.getText().toString()+", " + label5.getText() + "='"+field5.getSelectedItem().toString()+"', "+ label6.getText() 
                             + "='"+field6.getText()+"' WHERE emp_no="+field1.getText()+";");  
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
        
    
    v4.add(label1);
    v4.add(label2);
    v4.add(label3);
    v4.add(label4);
    v4.add(label5);
    v4.add(label6);
 
//    v.add(label8);
//    v.add(label9);
    
    v4.add(field1);
    v4.add(field2);
    v4.add(field3);
    v4.add(field4);
    v4.add(field5);
    v4.add(field6);
    
//    v.add(field8);
    
    v4.add(button);
    field5.addActionListener(listener);
    field6.addActionListener(listener);
    button.addActionListener(listener);


    
    v4.setLayout(null);
  v4.setResizable(false);
  v4.setSize(400,600);
  v4.setLocationRelativeTo(null);
  v4.setDefaultCloseOperation(v4.DISPOSE_ON_CLOSE);
  v4.setVisible(true);
    }
    
    
}

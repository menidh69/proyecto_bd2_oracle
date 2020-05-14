package ventanaUser2;


import CRUD_Classes.Department_man;
import CRUD_Classes.Employees;
import Conection.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import CRUD_Classes.*;
import javax.swing.ButtonGroup;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author propietario
 */
public class ventana_crud extends Thread{
    
    public void mostrarTabla (DefaultTableModel modelo, String consulta) {
  modelo.setRowCount(0);
  Conexion conn = new Conexion();
    
  Connection c = conn.miconexion();
  if (c != null) {
     
   try {
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(consulta);

    while(rs.next()) {
     Object[] tablaSQL = new Object[8];

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
    
    
    static String user;
 int rowCount;       

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    
    public ventana_crud(String user){
        this.user = user;
    }
    
 static DefaultTableModel modelo;
 static JTable tabla1;
 static  JScrollPane scroll1;
 JComboBox combobusqueda = new JComboBox();
 
JLabel load = new JLabel();
 JButton Pausar = new JButton ("Pausa");
 JButton Stop = new JButton ("Stop - Cancelar");
 JButton Reanudar = new JButton ("Reanudar");
 static Loader l ;
 
 public void run(){
     
  ventana_crud v3 = new ventana_crud(user);
  JFrame v = new JFrame("Ventana 3");

  

  tabla1 = new JTable(modelo);
  scroll1 = new JScrollPane(tabla1);
  boolean todo = false;
  JSpinner cantidadregistros = new JSpinner();
  cantidadregistros.setValue(100);
  JRadioButton amount = new JRadioButton("Cantidad");
  amount.setSelected(true);
  JRadioButton all = new JRadioButton("All");
  JButton boton1 = new JButton("Mostrar");
  JButton boton2 = new JButton("Update");
  JButton boton3 = new JButton("Insert");
  JButton boton4 = new JButton("Delete");
  JButton nuevoboton = new JButton("Buscar");
  nuevoboton.setBounds(20,435,100,25);
  
  JLabel labelbusqueda = new JLabel("Seleccione columna");
  JLabel labelbusqueda2 = new JLabel("de busqueda:");
  JTextField tx1 = new JTextField();
  
  
  JLabel bd = new JLabel("Base de Datos: Employees");
  JLabel bdtable = new JLabel("Seleccionar tabla");
  
  JComboBox combotable = new JComboBox();
    
JComboBox tx2 = new JComboBox();
  tx2.addItem("'True'");
  tx2.addItem("'False'");

  tx1.setBounds(20,400,100,25);
  tx2.setBounds(20,435,100,25);
  tx2.setEnabled(false);
  labelbusqueda.setBounds(20,300,150,25);
  labelbusqueda2.setBounds(20,325,100,25);
  boton1.setBounds(20,220,100,25);
  boton2.setBounds(120,220,100,25);
  boton3.setBounds(20,255,100,25);
  boton4.setBounds(120,255,100,25);
  tabla1.setBounds(20,85,250,150);
  scroll1.setBounds(250,20,900,650);
  bd.setBounds(20, 20, 400, 100);
  
  load.setBounds(20, 600, 150, 100);
  Stop.setBounds(20, 510, 150, 30);
  Pausar.setBounds(20, 540, 150, 30);
  Reanudar.setBounds(20, 570, 150, 30);
  bdtable.setBounds(20, 100, 150, 20);
  combotable.setBounds(20, 120, 200, 50);
  all.setBounds(20,170,150,30);
  amount.setBounds(20,190,150,30); 
  cantidadregistros.setBounds(120,190,100,30);
  combobusqueda.setBounds(20,365,200,25);
  ButtonGroup bg = new ButtonGroup();
  bg.add(all);
  bg.add(amount);
  
  
  Stop.setEnabled(false);
  Pausar.setEnabled(false);
  Reanudar.setEnabled(false);
  
  combotable.addItem("Seleccione una tabla");
  combotable.addItem("employees");
  combotable.addItem("departments");
  combotable.addItem("dept_manager");
  combotable.addItem("dept_emp");
  combotable.addItem("titles");
  combotable.addItem("salaries");

    
combotable.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
            modelo = (DefaultTableModel)tabla1.getModel();
            modelo.setColumnCount(0);
            String combostring = combotable.getSelectedItem().toString();
            combobusqueda.removeAllItems();
            switch(combostring){
                
                case "Seleccione una tabla":
                    
                    break;
            case "employees":
                modelo.addColumn("emp_no");
                modelo.addColumn("birth_date");
                modelo.addColumn("first_name");
                modelo.addColumn("last_name");
                modelo.addColumn("gender");
                modelo.addColumn("hire_date");
               

                combobusqueda.addItem("Seleccione columna");
               combobusqueda.addItem("emp_no");
                combobusqueda.addItem("birth_date");
                combobusqueda.addItem("first_name");
               combobusqueda.addItem("last_name");
               combobusqueda.addItem("gender");
               combobusqueda.addItem("hire_date");
            
                break;
                
            case "departments":
                modelo.addColumn("dept_no");
                modelo.addColumn("dept_name");
                combobusqueda.addItem("Seleccione columna");
                
                combobusqueda.addItem("dept_no");
                combobusqueda.addItem("dept_name");
                
                break;    
            
            case "dept_manager":
                modelo.addColumn("emp_no");
                modelo.addColumn("dept_no");
                modelo.addColumn("from_date");
                modelo.addColumn("to_date");
                
                combobusqueda.addItem("Seleccione columna");
                combobusqueda.addItem("emp_no");
                combobusqueda.addItem("dept_no");
                combobusqueda.addItem("from_date");
                combobusqueda.addItem("to_date");
                break;
                
            case "dept_emp":
                modelo.addColumn("emp_no");
                modelo.addColumn("dept_no");
                modelo.addColumn("from_date");
                modelo.addColumn("to_date");
                
               combobusqueda.addItem("Seleccione columna");
                combobusqueda.addItem("emp_no");
                combobusqueda.addItem("dept_no");
               combobusqueda.addItem("from_date");
                combobusqueda.addItem("to_date");
               
                
                break;
            case "titles":
                modelo.addColumn("emp_no");
                modelo.addColumn("title");
                modelo.addColumn("from_date");
                modelo.addColumn("to_date");
                
                combobusqueda.addItem("Seleccione columna");
                combobusqueda.addItem("emp_no");
               combobusqueda.addItem("title");
                combobusqueda.addItem("from_date");
                combobusqueda.addItem("to_date");
               
                
                break;    
                
            case "salaries":
                modelo.addColumn("emp_no");
                modelo.addColumn("salary");
                modelo.addColumn("from_date");
                modelo.addColumn("to_date");
                
                combobusqueda.addItem("Seleccione columna");
                 combobusqueda.addItem("emp_no");
               combobusqueda.addItem("salary");
                combobusqueda.addItem("from_date");
                combobusqueda.addItem("to_date");
                break;    
                
                
        }
//            tabla1 = new JTable(modelo);
//            scroll1 = new JScrollPane(tabla1);        

      }
  })
     
 ;
  tx1.addKeyListener(new KeyListener(){
    
    public void keyPressed(KeyEvent ke){
      
    }

    public void keyReleased(KeyEvent ke){
        if (combotable.getSelectedItem().equals("Seleccione una tabla")){
          JOptionPane.showMessageDialog(null, "Selecciona una tabla primero");
          tx1.setText("");
      }else{
      if (combobusqueda.getSelectedItem().equals("Seleccione columna")){
          JOptionPane.showMessageDialog(null, "Selecciona una columna primero");
          tx1.setText("");
//      }else{
//          
//      
//      
//      
//      String dato = tx1.getText();
//      String consulta = "SELECT * FROM "+ combotable.getSelectedItem().toString() +" WHERE " + combobusqueda.getSelectedItem().toString() +" LIKE '"+ dato + "%'";
//      v3.mostrarTabla(modelo, consulta);
//      }
        }
    }
    }


    public void keyTyped(KeyEvent ke){}
  });
  
  ActionListener listener = new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
       
       
       if(e.getSource()==nuevoboton){ //BOTON BUSCAR
           if(combobusqueda.getSelectedItem().equals("emp_no") || combobusqueda.getSelectedItem().equals("salary")){
               String consulta = "SELECT * FROM meni."+ 
combotable.getSelectedItem().toString() +" WHERE meni." + combobusqueda.getSelectedItem().toString() +" = "+ tx1.getText() ;
      v3.mostrarTabla(modelo, consulta);
           }else{
           String consulta = "SELECT * FROM meni."+ 
combotable.getSelectedItem().toString() +" WHERE meni." + combobusqueda.getSelectedItem().toString() +" = '"+ tx1.getText()+"'" ;
      v3.mostrarTabla(modelo, consulta);
       }
       }       
       
       
       
    if(e.getSource() == boton1) {//BOTON MOSTRAR
        String tabla = combotable.getSelectedItem().toString();
        if(tabla.equals("Departments")){
            
            mostrarTabla(modelo,"SELECT * FROM meni.departments");
        }else if(tabla.equals("dept_manager")){
            mostrarTabla(modelo,"SELECT * FROM meni.dept_manager");
        }else{
        String queryamount ;
        int rows = 0;
        if(all.isSelected()){   
            queryamount = "SELECT COUNT(*) FROM meni."+tabla;
            Conexion conn = new Conexion();
            Connection c = conn.miconexion();
            try{
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(queryamount);
            while(r.next()){
                rows = r.getInt("COUNT(*)");
            }
            }catch(SQLException e11){}
        }else{
            rows = (Integer) cantidadregistros.getValue();
            }
        JProgressBar b = new JProgressBar(0,rows);
        b.setBounds(20, 40, 150, 100);
        v.add(b);
        
         System.out.println(tabla);
        l = new Loader("Query",modelo, "SELECT * FROM meni."+tabla+" WHERE emp_no=",10000, b, load, rows);
        l.start();
        Pausar.setEnabled(true);
        Stop.setEnabled(true);
        }
               
                
    } //fin de boton1 mostrar
    
     if(e.getSource()==Pausar){
        Reanudar.setEnabled(true);
        Pausar.setEnabled(false);
        l.suspenderHilo();    
        load.setText("Loading Paused");
                }
     if(e.getSource()==Reanudar){
        Reanudar.setEnabled(false);
        Pausar.setEnabled(true);    
        l.reanudarHilo();
        load.setText("Loading...");
                }
     if(e.getSource()==Stop){
        Reanudar.setEnabled(false);
        Pausar.setEnabled(false);    
        Stop.setEnabled(false);
        l.stopHilo();
        load.setText("Cancelled");
        
                }

     
     
     
   if(e.getSource() == boton4) { //BOTON BORRAR
    Object id = "";
    boolean status_id = true;

    try {
     int linea_id = tabla1.getSelectedRow();
     id = tabla1.getValueAt(linea_id, 0);
    } catch(Exception e13) {
     status_id = false;
        System.out.println(e13);
     JOptionPane.showMessageDialog(null, "No hay dato seleccionado");
    }

    if (status_id) {
     int confirmar = JOptionPane.showConfirmDialog(null, "Estas segurito, segurito?", "Confirmar", JOptionPane.YES_NO_OPTION);
     if(confirmar == 0) {
      //JOptionPane.showMessageDialog(null, "Si lo vas a eliminar");
      Conexion connn = new Conexion();
      Connection c = connn.miconexion();

      if(c != null) {
       try {
        Statement std = c.createStatement();
        
            switch(combotable.getSelectedItem().toString()){
                case "employees":
                    std.executeUpdate("DELETE FROM meni.employees  WHERE meni.emp_no = " + id);
            
                    
                    break;
                case "departments":
                         std.executeUpdate("DELETE FROM meni.departments  WHERE dept_no = '" + id+"'");
            
           
                        break;
                case "dept_emp":
                         std.executeUpdate("DELETE FROM meni.dept_emp  WHERE emp_no = " + id);
            
           
                        break;        
                case "dept_manager":
                         std.executeUpdate("DELETE FROM meni.dept_manager  WHERE emp_no = " + id);
           
            
                        break;
                
                case "titles":
                         std.executeUpdate("DELETE FROM meni.titles  WHERE emp_no = " + id);
           
            
                        break;
                case "salaries":
                         std.executeUpdate("DELETE FROM meni.salaries  WHERE emp_no = " + id);
            
            
                        break;
            
            }
            
        c.close();
        JOptionPane.showMessageDialog(null, "Borraste la informacion, chale!! \n Haz click en mostrar para actualizar");
        
       } catch(SQLException se9) {
        JOptionPane.showMessageDialog(null, se9);
       }
      }
     }
    }
   } //fin boton4 borrar

   if(e.getSource() == boton3) { //BOTON INSERT
           
               String valor;
               valor = combotable.getSelectedItem().toString();
               
               switch (valor){
                   case "Seleccione una tabla":
                       
                       break;
                   case "employees":
                       insertEmployee emp = new insertEmployee(user);
                       emp.setVisible(true);
              
                       break;
                       
                   case "departments":
                       insertDept dept = new insertDept();
                       dept.setVisible(true);
                       
                       break;
                       
                   case "dept_manager":
                       Department_man v2 = new Department_man(v);
               
                   try {
                       v2.show(true);
                   } catch (SQLException ex) {}
                    break;
                       
                   case "dept_emp":
                       Department_man depemp = new Department_man(v);
                       try{
                       depemp.show(false);
                       }catch(SQLException ex){}
                       break;
                   case "titles":
                       Titles t = new Titles(v);
               {
                   try {
                       t.show();
                   } catch (SQLException ex) {
                       Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                       
                       
                       break;
                       
                   case "salaries":
                       Salaries s = new Salaries(v);
               {
                   try {
                       s.show();
                   } catch (SQLException ex) {
                       Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
                       break;
                       
                       
               }   } 
    
   

   if(e.getSource() == boton2) { //BOTON UPDATE
     
     int linea = tabla1.getSelectedRow();
     
     if(linea != -1) {
      
      
      
      
        String valor;
       valor = combotable.getSelectedItem().toString();
       
       switch (valor){
           case "Seleccione una tabla":
                    
                    break;
           case "employees":
               Employees emp1 = new Employees(v);
        {
            try {
                emp1.update(linea, tabla1);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                
            case "departments":
               Departments dep = new Departments();
               try{ 
               dep.update(linea, tabla1);}catch(SQLException ex){}
                break;    
            
            case "dept_manager":
               Department_man v2 = new Department_man(v);
        {
            try {
                v2.update(linea, tabla1, true);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                
            case "dept_emp":
               Department_man depemp = new Department_man(v);
                       try{
                       depemp.update(linea, tabla1, false);
                       }catch(SQLException ex){}
               
                
                break;
            case "titles":
               Titles t = new Titles(v);
        {
            try {
                t.update(linea, tabla1);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               
                
                break;        
                
            case "salaries":
              Salaries s = new Salaries(v);
        {
            try {
                s.update(linea, tabla1);
            } catch (SQLException ex) {
                Logger.getLogger(ventana_crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;      
       }
         
         
      
     } else {
      JOptionPane.showMessageDialog(null, "No has seleccionado un dato! :(");
     }
     
    /*try {
     int linea = tabla1.getSelectedRow();
     JOptionPane.showMessageDialog(null, tabla1.getValueAt(linea,1) + ", " + tabla1.getValueAt(linea,2) + ", " + tabla1.getValueAt(linea,3) + ", " + tabla1.getValueAt(linea,4));
    } catch(Exception ex2) {
     JOptionPane.showMessageDialog(null, "No has seleccionado un dato! :(");
    }*/
    
   }
    
   }
  };

  boton1.addActionListener(listener);
  boton2.addActionListener(listener);
  boton3.addActionListener(listener);
  boton4.addActionListener(listener);
  nuevoboton.addActionListener(listener);
  Pausar.addActionListener(listener);
  Stop.addActionListener(listener);
  Reanudar.addActionListener(listener);
  v.add(tx1);
  v.add(boton1);
  v.add(boton2);
  v.add(boton3);
  v.add(boton4);
  v.add(scroll1);
  v.add(labelbusqueda);
   v.add(labelbusqueda2);
  v.add(bd);
  v.add(bdtable);
  v.add(combotable);
  v.add(combobusqueda);
  v.add(nuevoboton);
  
  v.add(load);
  v.add(amount);
  v.add(all);
  v.add(cantidadregistros);
  v.add(Stop);
  v.add(Pausar);
  v.add(Reanudar);
  

  v.setLayout(null);
  v.setResizable(false);
  v.setSize(1200,700);
  v.setLocationRelativeTo(null);
  v.setDefaultCloseOperation(v.EXIT_ON_CLOSE);
  v.setVisible(true);
  

 }
 
 

 }
 





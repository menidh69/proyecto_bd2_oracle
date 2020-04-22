/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_Classes;

import Conection.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author propietario
 */
public class Loader extends Thread {
    Thread t;
    DefaultTableModel modelo;
    String consulta;
    int id;
    JProgressBar b;
    JLabel texto;
    boolean suspender;
    boolean pausar;
    int rows;
    JButton pausa, stop, resume;
    public Loader(String name, DefaultTableModel modelo,
            String consulta, int id, JProgressBar b, JLabel texto, int rows){
        t = new Thread(this, name);
        this.b = b;
        this.consulta = consulta;
        this.id = id;
        this.modelo = modelo;
        this.texto = texto;
        this.pausa = pausa;
        this.stop = stop;
        this.resume = resume;
        this.rows = rows;
    }
    
    public void run(){
        texto.setText("Loading...");
        b.setVisible(true);
        texto.setVisible(true);
        modelo.setRowCount(0);
        Conexion conn = new Conexion();
        
        Connection c = conn.miconexion();
        if (c != null) {
        
            for (int i= 0; i<rows+1; i++){
                
                b.setValue(i);
               String query = consulta + String.valueOf(id);
                try {
                    Statement st = c.createStatement();
                    ResultSet rs = st.executeQuery(query);
                     while(rs.next()) {
                        Object[] tablaSQL = new Object[8];
                        for(int ii=0; ii<=modelo.getColumnCount()-1; ii++) {
                             tablaSQL[ii] = rs.getObject(ii+1);
                        }
                         modelo.addRow(tablaSQL);
                     }
                     synchronized (this){
                        while(suspender){
                            wait();
                        }
                        if (pausar){
                            break;
                        }
                }
                }catch(SQLException e){
                    e.printStackTrace();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(i==rows){
                    b.setVisible(false);
                    texto.setText("Finished Loading");
                    texto.setVisible(true);
                }else{
                id++;
                }
            }
    }
    }
    
    public void prueba (String count) {
  modelo.setRowCount(0);
  int rows=0;
  Conexion conn = new Conexion();
    
  Connection c = conn.miconexion();
  if (c != null) {
     
   try {
    Statement st = c.createStatement();
    ResultSet r = st.executeQuery(count);
            while(r.next()){
                rows = r.getInt("COUNT(*)");
                b = new JProgressBar(0,rows);
            }
           
    
    ResultSet rs = st.executeQuery(consulta);
    int counter = 0;
    while(rs.next()) {
     Object[] tablaSQL = new Object[8];

     for(int i=0; i<=modelo.getColumnCount()-1; i++) {
     tablaSQL[i] = rs.getObject(i+1);
    }
     
    modelo.addRow(tablaSQL);
    counter++;
    b.setValue(counter);
   }
   c.close();
   } catch(SQLException se) {
    JOptionPane.showMessageDialog(null, se);
   }
  }
 }
    
    
   public synchronized void suspenderHilo(){
        suspender = true;
    }
    
    
   public synchronized void reanudarHilo(){
        suspender = false;
        notify();
    }
    
   public synchronized void stopHilo(){
        suspender = false;
        pausar = true;
        notify();
    }
  }
 
 


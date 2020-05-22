package CRUD_Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author propietario
 */
import Conection.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author propietario
 */
public class QueryComboClass {
    
    JComboBox<String> combo = new JComboBox<>();
    
    
    public void prueba(String query, String llave) throws SQLException{
        
    ArrayList<Object> llaves = new ArrayList<>();
        
        try{
        Conexion conn = new Conexion();
        Connection c = conn.miconexion(2);
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Object cat = rs.getObject(llave);
            // add cat's ids tp the array list
            llaves.add(cat.toString());
        }
        
        rs.close();
        c.close();
        // populate the combo box
        DefaultComboBoxModel model = new DefaultComboBoxModel(llaves.toArray());
        combo.setModel(model);
    }catch(Exception e){
            System.out.println(e);
    }
    }
        

    
//    public void SetQueryCombo(String consulta, JComboBox<Object> llavesitas) {
//  this.llavesitas = llavesitas;
//  Conexion3 conn = new Conexion3();
//    int i = 0;
//    
//  Connection c = conn.miconexion();
//  if (c != null) {
//   try {
//    Statement st = c.createStatement();
//    ResultSet rs = st.executeQuery(consulta);
//
//    while(rs.next()) {
//     
//
//    
//     llavesitas.addItem(rs.getObject(i+1));
//     
//    
//
//   
//   }
//   c.close();
//   } catch(SQLException se) {
//    JOptionPane.showMessageDialog(null, se);
//   }
//  }
// }
    
  public JComboBox<String> GetQueryCombo(){
      return combo;
  }
    
}
    

package CRUD_Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author propietario
 */
public class Conexion {
    public Connection miconexion() {

        String ip = "";
  final String URL_DB = "jdbc:oracle:thin:@"+ip+":1521:xe";
  
        
        
        final String USER_DB = "usuario1";
        final String PASS_DB = "manzana";

    
    int b = 0;

    try {
     Class.forName("oracle.jdbc.OracleDriver");
     System.out.println("Driver correcto!");
     b = 1;
    } catch(ClassNotFoundException ex) {
     JOptionPane.showMessageDialog(null, ex);
    }

    Connection c = null;
    
     if (b == 1){
     try{
      c = DriverManager.getConnection(URL_DB, USER_DB, PASS_DB);
      System.out.println("Conexion correcta!");
      //JOptionPane.showMessageDialog(null, "Conexion correcta!");
     } catch(SQLException s) {
      System.out.println(s);
      JOptionPane.showMessageDialog(null,s);
    }

//    if (b == 1){
//     try{
//      c = DriverManager.getConnection(URL_DB, USER_DB, PASS_DB);
//      System.out.println("Conexion correcta!");
//      //JOptionPane.showMessageDialog(null, "Conexion correcta!");
//     } catch(SQLException s) {
//      System.out.println(s);
//      JOptionPane.showMessageDialog(null,s);
//    }
   
}
    return c;
}

}

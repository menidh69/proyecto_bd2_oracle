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
import java.sql.Statement;

/**
 *
 * @author propietario
 */
public class QueryLastID {
    String ids = "";
    
    public void setNewID(String query, String columnname){
    try{
        Conexion conn = new Conexion();
        Connection c = conn.miconexion();
        Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        ResultSet rs = st.executeQuery(query);
        
        rs.afterLast();
        while (rs.previous()) {
            ids = rs.getString(columnname);
            break;
        }
        int result = Integer.parseInt(ids)+1;
        ids = Integer.toString(result);
        
        }catch(Exception e){
        System.out.println(e);
        }
    }
    
    public String getNewID(){
        
        return ids;
    }
}
    

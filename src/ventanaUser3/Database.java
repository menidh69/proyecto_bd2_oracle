package ventanaUser3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Alondra
 */
public class Database {

    private Connection con;

    //URL que identifica a la base de datos que nos queremos conectar
    //private final String DB_URL = "jdbc:mysql://148.225.64.69:3306/db210215739";
    //private final String DB_URL = "jdbc:mysql://localhost:3306/COFFEES";
    String ip = "34.94.152.5";
    private final String DB_URL = "jdbc:oracle:thin:@"+ip+":1521:xe";

    //Driver de JDBC que vamos a usar para conectarnos a la base de datos
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private static Database DB = null;
     final String user = "usuario3";
        final String password = "platano";
   

    public Database() {
        super();
        con = null;
       
        try {

            // Cargar el driver
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            // Abrir una conexion a la base de datos
            con = DriverManager.getConnection(DB_URL, props);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Codigo : " + ex.getErrorCode());
        }
    }

    // Abrir la conexión y regresar objeto Database
    public static Database getDatabase() {
        if (DB == null) {
            DB = new Database();
        }
        return DB;
    }

    public ResultSet query(String sql) throws SQLException {

        ResultSet rs = null;
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = statement.executeQuery(sql);

        return rs;
    }

    public ResultSet query(String sql, int scroll, int concur) throws SQLException {

        ResultSet rs = null;

        Statement statement = con.createStatement(scroll, concur);
        rs = statement.executeQuery(sql);

        return rs;
    }

    public int update(String sql) throws SQLException {
        int result = -1;

        Statement statement = con.createStatement( ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE );
        result = statement.executeUpdate(sql);
        return result;
    }
}

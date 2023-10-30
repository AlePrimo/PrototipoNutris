
package AccesoADatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class Conexion {
    
    private  static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="nutris";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConnection(){
    
    if (connection==null){
    
        try {
           Class.forName("org.mariadb.jdbc.Driver");
              connection=DriverManager.getConnection(URL+DB+ "?useLegacyDateTimeCode=false&server&TimeZone=UTC"+"&user="+USUARIO+"&password="+PASSWORD);
                    
//            JOptionPane.showMessageDialog(null,"Error al cargar los drivers "+ex.getMessage() );
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al conectarse a base de datos "+ex.getMessage() );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    return connection;
    }
    
    
    
    
    
    
    
    
}


package AccesoADatos;


import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//ME ESTA TIRANDO ERROR!!

public class PacienteData {
    
    private Paciente paciente;
    private Connection con=null;

    public PacienteData() {
       con= Conexion.getConnection();
    }
    
    public void ingresarPaciente(Paciente paciente) {

        String sql = "INSERT INTO nutris.paciente  (nombre, apellido, dni, altura, domicilio, telefonoFijo, celular, mail)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setDouble(4, paciente.getAltura());
            ps.setString(5, paciente.getDomicilio());
            ps.setString(6, paciente.getTelefonoFijo());
            ps.setString(7, paciente.getCelular());
            ps.setString(8, paciente.getMail());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ingreso un paciente con id :" + paciente.getIdPaciente());
              
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de pacientes");
            
        }

    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

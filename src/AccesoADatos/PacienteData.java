
package AccesoADatos;


import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class PacienteData {
    
    private Paciente paciente;
    private Connection con=null;

    public PacienteData() {
       con= Conexion.getConnection();
    }
    
    public void ingresarPaciente(Paciente paciente) {

        String sql = "INSERT INTO nutris.paciente  (nombre, apellido, dni, altura, domicilio, telefonoFijo, celular, mail, estado)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            ps.setBoolean(9, paciente.isEstado());
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
    
    
    
    public Paciente buscarPacientePorDni(int dni) {

        String sql = "SELECT * FROM nutris.paciente WHERE dni=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               paciente = new Paciente();
               paciente.setIdPaciente(rs.getInt("idPaciente"));
               paciente.setNombre(rs.getString("nombre"));
               paciente.setApellido(rs.getString("apellido"));
               paciente.setDni(rs.getInt("dni"));
               paciente.setAltura(rs.getDouble("altura"));
               paciente.setDomicilio(rs.getString("domicilio"));
               paciente.setTelefonoFijo(rs.getString("telefonoFijo"));
               paciente.setCelular(rs.getString("celular"));
               paciente.setMail(rs.getString("mail"));
               paciente.setEstado(rs.getBoolean("estado"));
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe un paciente con ese dni ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla paciente");
        }

        return paciente;

    } 
    
    
    
    public Paciente buscarPacientePorId(int id) {

        String sql = "SELECT * FROM nutris.paciente WHERE idPaciente=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               paciente = new Paciente();
               paciente.setIdPaciente(id);
               paciente.setNombre(rs.getString("nombre"));
               paciente.setApellido(rs.getString("apellido"));
               paciente.setDni(rs.getInt("dni"));
               paciente.setAltura(rs.getDouble("altura"));
               paciente.setDomicilio(rs.getString("domicilio"));
               paciente.setTelefonoFijo(rs.getString("telefonoFijo"));
               paciente.setCelular(rs.getString("celular"));
               paciente.setMail(rs.getString("mail"));
               paciente.setEstado(rs.getBoolean("estado"));
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe un paciente con ese dni ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla paciente");
        }

        return paciente;

    }
    
    
    
     public void bajaPaciente(int id) {
        String sql = "Update nutris.paciente set estado=0 where idPaciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int carga = ps.executeUpdate();
            if (carga == 1) {
                JOptionPane.showMessageDialog(null, "Se ha dado de baja al paciente con id :" + id);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla paciente");
        }

    } 
    
    
    
     public void modificarPaciente(Paciente paciente) {

        String sql = "UPDATE nutris.paciente SET nombre=?, apellido=?, dni=?, altura=?, domicilio=?, "
                + "telefonoFijo=?, celular=?, mail=? estado=? WHERE idPaciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
             ps.setString(2, paciente.getApellido());
             ps.setInt(3,paciente.getDni());
             ps.setDouble(4,paciente.getAltura());
             ps.setString(5, paciente.getDomicilio());
              ps.setString(6, paciente.getTelefonoFijo());
             ps.setString(7, paciente.getCelular());
              ps.setString(8, paciente.getMail());
               ps.setBoolean(9, paciente.isEstado());
              ps.setInt(10, paciente.getIdPaciente());
          
            int carga = ps.executeUpdate();
            
            if (carga == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el paciente con id :" + paciente.getIdPaciente());

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de Pacientes");
        }

    }

    
    
    
    
    
     public List<Paciente> listarPacientes() {

        String sql = "SELECT * FROM nutris.paciente ";
        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                paciente = new Paciente();
               paciente.setIdPaciente(rs.getInt("idPaciente"));
               paciente.setNombre(rs.getString("nombre"));
               paciente.setApellido(rs.getString("apellido"));
               paciente.setDni(rs.getInt("dni"));
               paciente.setAltura(rs.getDouble("altura"));
               paciente.setDomicilio(rs.getString("domicilio"));
               paciente.setTelefonoFijo(rs.getString("telefonoFijo"));
               paciente.setCelular(rs.getString("celular"));
               paciente.setMail(rs.getString("mail"));
               paciente.setEstado(rs.getBoolean("estado"));
               pacientes.add(paciente);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de pacientes");
        }

        return pacientes;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

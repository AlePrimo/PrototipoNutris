
package AccesoADatos;

import Entidades.Dieta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DietaData {
    
     private Dieta dieta=new Dieta();
    
    private Connection con=null;

    public DietaData() {
        con= Conexion.getConnection();
       
    }
    
    public void ingresarDieta(Dieta dieta) {

        String sql = "INSERT INTO nutris.dieta  (nombre, idpaciente, fechaInicio, fechaFinal, pesoInicial, pesoFinal, estado)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicio()));
            ps.setDate(4, Date.valueOf(dieta.getFechaInicio()));
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setBoolean(6, dieta.isEstado());
            
            ps.executeUpdate();

           ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                dieta.setIdDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ingreso una dieta con id :" + dieta.getIdDieta());
              
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de dietas");
            
        }

    } 
    
    
     public Dieta buscarDietaPorPaciente(int idPaciente) {

        String sql = "SELECT * FROM nutris.dieta WHERE idpaciente=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
               dieta.setIdDieta(rs.getInt("idDieta"));
               dieta.setNombre(rs.getString("nombre"));
               dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
               dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
               dieta.setPesoInicial(rs.getDouble("pesoInicial"));
               dieta.setPesoFinal(rs.getDouble("pesoFinal"));
               dieta.setEstado(rs.getBoolean("estado"));              
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe una dieta con ese dni ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla dieta");
        }

        return dieta;

    }
    
    
    
    
     public Dieta buscarDietaPorId(int id) {

        String sql = "SELECT * FROM nutris.dieta WHERE idDieta=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
               dieta.setIdDieta(id);
              
               dieta.setNombre(rs.getString("nombre"));
               dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
               dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
               dieta.setPesoInicial(rs.getDouble("pesoInicial"));
               dieta.setPesoFinal(rs.getDouble("pesoFinal"));
               dieta.setEstado(rs.getBoolean("estado")); 
               
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe un dieta con ese dni ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla dieta");
        }

        return dieta;

    }
    
    
    public void eliminarDieta(int id){
        
        String sql="UPDATE dieta SET estado=0 WHERE idDieta=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Dieta suspendida");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla dieta");
       }          
        
    } 
    
    
 public void modificarDieta(Dieta dieta) {

        String sql = "UPDATE nutris.dieta SET nombre,fechaInicio, fechaFinal, pesoInicial, pesoFinal, estado "
                + " WHERE idDieta=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
             ps.setDate(2, Date.valueOf(dieta.getFechaInicio()));
             ps.setDate(3, Date.valueOf(dieta.getFechaInicio()));             
             ps.setDouble(4,dieta.getPesoInicial());
             ps.setDouble(5,dieta.getPesoFinal());
             ps.setBoolean(6,dieta.isEstado());
            
            int carga = ps.executeUpdate();
            
            if (carga == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el dieta con id :" + dieta.getIdDieta());

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de Dietas");
        }

    }   
    
    
    public List<Dieta> listarDietas() {

        String sql = "SELECT * FROM nutris.dieta ";
        ArrayList<Dieta> dietasList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {                
                
               dieta.setIdDieta(rs.getInt("idDieta"));
               dieta.setNombre(rs.getString("nombre"));
               dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
               dieta.setFechaFinal(rs.getDate("fechaInicio").toLocalDate());
               dieta.setPesoInicial(rs.getDouble("pesoInicial"));
               dieta.setPesoFinal(rs.getDouble("pesoFinal"));
               dieta.setEstado(rs.getBoolean("estado"));
               
               dietasList.add(dieta);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos de dietas");
        }

        return dietasList;
    }
 
    
    
    
    
    
    
    
}



package AccesoADatos;

import Entidades.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ComidaData {
    
    private  Connection con=null;
    private Comida comida=new Comida();

    public ComidaData() {
        
        con = Conexion.getConnection();
    }
    
    public void guardarComida(Comida comida) {
        
        String sql = "INSERT INTO nutris.comida (nombre, detalle, calorias) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setDouble(3, comida.getCalorias());
            
            ps.executeUpdate();

            ResultSet res = ps.getGeneratedKeys();

            if (res.next()) {

                comida.setIdComida(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida agregada con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla Comida");

        }

    }
    
    public void borrarComida(int idComida) {

        String sql = "DELETE FROM nutris.comida WHERE idComida=?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idComida);
            
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Borrado exitoso");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos Comidas");
        }

    }
    
    public List<Comida> obtenerComidas() {

        ArrayList<Comida> comidasList = new ArrayList<>();
        String sql = "SELECT * FROM nutris.comida";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comi = new Comida();
                comi.setIdComida(rs.getInt("idComida"));
                comi.setNombre(rs.getString("nombre"));
                comi.setDetalle(rs.getString("detalle"));
                comi.setCalorias(rs.getDouble("calorias"));
                comidasList.add(comi);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos Comidas");
        }
        
        return comidasList;
        
    }
    
    public Comida buscarComida(int id) {

        String sql = "SELECT * FROM nutris.comida WHERE idComida=? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                
                comida.setIdComida(id);
                comida.setNombre(rs.getString("nombre"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCalorias(rs.getDouble("calorias"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe una comida con ese id ,ingrese el dato nuevamente!");
               
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos Comidas");
            
        }

        return comida;
    }
    
    public void modificarComida( Comida comida){
    String sql = "UPDATE nutris.comida SET nombre=?, detalle=?, calorias=? WHERE idComida=?";
    
    
     try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setDouble(3, comida.getCalorias());
            ps.setInt(4, comida.getIdComida());
            int res=ps.executeUpdate();

           

            if (res==1) {

               
                JOptionPane.showMessageDialog(null, "Comida modificada con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla Comida");

        }

    
    
    }
    
    
    
    
    
    
    
    
}


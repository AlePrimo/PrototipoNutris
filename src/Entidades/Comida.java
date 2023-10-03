
package Entidades;


public class Comida {
    private int idComida;
    private String nombre,detalle;
    private double calorias;

    public Comida() {
    }

    public Comida(String nombre, String detalle, double calorias) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
    }

    public Comida(int idComida, String nombre, String detalle, double calorias) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.detalle = detalle;
        this.calorias = calorias;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", nombre=" + nombre + ", detalle=" + detalle + ", calorias=" + calorias + '}';
    }
    
    
    
    
    
}


package Entidades;


public class Paciente extends Persona {
    
    private int idPaciente; 
    private double altura;
    private String domicilio,telefonoFijo;

    public Paciente() {
    }    

    public Paciente(double altura,String domicilio, String telefonoFijo, String apellido, String nombre, int dni, String celular, String mail) {
        super(apellido, nombre, dni, celular, mail);
        this.altura= altura;
        this.domicilio = domicilio;
        this.telefonoFijo = telefonoFijo;
    }    

    public Paciente(int idPaciente,double altura, String domicilio, String telefonoFijo, String apellido, String nombre, int dni, String celular, String mail) {
        super(apellido, nombre, dni, celular, mail);
        this.altura= altura;
        this.idPaciente = idPaciente;
        this.domicilio = domicilio;
        this.telefonoFijo = telefonoFijo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    @Override
    public String toString() {
        return "idPaciente=" + idPaciente +"Altura=  "+altura+", domicilio=" + domicilio + ", telefonoFijo=" + telefonoFijo;
    }      
}

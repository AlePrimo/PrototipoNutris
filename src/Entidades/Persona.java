//
package Entidades;


public class Persona {
    private String apellido, nombre;
    private int dni;
    private String celular, mail;

    public Persona() {
    }

    public Persona(String apellido, String nombre, int dni, String celular, String mail) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.mail = mail;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "apellido= "+ apellido + ", nombre=" + nombre + ", dni=" + dni + ", celular=" + celular + ", mail=" + mail;
    }   
    
}

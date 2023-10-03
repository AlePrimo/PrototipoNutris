
package Entidades;


public class Profesional extends Persona {
    
    private int idProfesional;
    private String matricula, telefonoProfesional;

    public Profesional() {
    }

    public Profesional(String matricula, String telefonoProfesional) {
        this.matricula = matricula;
        this.telefonoProfesional = telefonoProfesional;
    }

    public Profesional(String matricula, String telefonoProfesional, String apellido, String nombre, int dni, String celular, String mail) {
        super(apellido, nombre, dni, celular, mail);
        this.matricula = matricula;
        this.telefonoProfesional = telefonoProfesional;
    }

    public Profesional(int idProfesional, String matricula, String telefonoProfesional) {
        this.idProfesional = idProfesional;
        this.matricula = matricula;
        this.telefonoProfesional = telefonoProfesional;
    }

    public Profesional(int idProfesional, String matricula, String telefonoProfesional, String apellido, String nombre, int dni, String celular, String mail) {
        super(apellido, nombre, dni, celular, mail);
        this.idProfesional = idProfesional;
        this.matricula = matricula;
        this.telefonoProfesional = telefonoProfesional;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefonoProfesional() {
        return telefonoProfesional;
    }

    public void setTelefonoProfesional(String telefonoProfesional) {
        this.telefonoProfesional = telefonoProfesional;
    }

    @Override
    public String toString() {
        return "idProfesional=" + idProfesional + ", matricula=" + matricula + ", telefonoProfesional=" + telefonoProfesional ;
    }
    
    
}

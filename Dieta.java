
package Entidades;

import java.time.LocalDate;


public class Dieta {
    
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private Profesional profecional;
    private LocalDate fechaInicio, fechaFinal;
    private double pesoInicial, pesoFinal;
    private boolean estado;

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, Profesional profecional, LocalDate fechaInicio, LocalDate fechaFinal, double pesoInicial, double pesoFinal, boolean estado) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.profecional = profecional;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, Profesional profecional, LocalDate fechaInicio, LocalDate fechaFinal, double pesoInicial, double pesoFinal, boolean estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.profecional = profecional;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, Profesional profecional, LocalDate fechaInicio, double pesoInicial, double pesoFinal, boolean estado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.profecional = profecional;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
    }

    public Dieta(String nombre, Paciente paciente, Profesional profecional, LocalDate fechaInicio, double pesoInicial, boolean estado) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.profecional = profecional;
        this.fechaInicio = fechaInicio;
        this.pesoInicial = pesoInicial;
        this.estado = estado;
    }
    

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profesional getProfecional() {
        return profecional;
    }

    public void setProfecional(Profesional profecional) {
        this.profecional = profecional;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "idDieta=" + idDieta + ", nombre=" + nombre + ", paciente=" + paciente + ", profecional=" + profecional + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", pesoInicial=" + pesoInicial + ", pesoFinal=" + pesoFinal + ", estado=" + estado;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutris;

import AccesoADatos.ComidaData;
import AccesoADatos.Conexion;
import AccesoADatos.DietaComidaData;
import AccesoADatos.DietaData;
import AccesoADatos.HistorialData;
import AccesoADatos.PacienteData;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.DietaComida;
import Entidades.Historial;
import Entidades.Horario;
import Entidades.Paciente;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public class Nutris {

private static List<Dieta>listNorpp=new ArrayList<>();
private static List<Dieta>listEstadoTermado=new ArrayList<>();
private static List<Dieta>listEstadoEnCurso=new ArrayList<>();
   
    public static void main(String[] args) {
        
        
        
        
        
        
        
        // TODO code application logic here

//ALTA DE ENTIDADES

PacienteData pd =new PacienteData(Conexion.getConnection());
//Paciente p1=new Paciente (1.80,"salala 1987","4612-1866",true,"Carletti","Pedro","33666888","1548889632","carletti@hotmail.com",LocalDate.of(1945, Month.MARCH, 5));
//Paciente p2=new Paciente (1.60,"andala 87","4633-2266",true,"Perez","Hugo","3355888","1889632","hugo@hotmail.com",LocalDate.of(1978, Month.APRIL, 2));
//pd.ingresarPaciente(p2);
////pd.ingresarPaciente(p1);

DietaData dd=new DietaData(Conexion.getConnection());
//Dieta d1=new Dieta("Keto", pd.buscarPacientePorDni("3355888"), LocalDate.of(2023, Month.MARCH, 1), LocalDate.of(2023, Month.JUNE, 1), 95, 95, true);
//
//dd.ingresarDieta(d1);

//Comida des=new Comida("Tostadas","Tres tostadas con queso port salut", 200, true);
//Comida col=new Comida("Frutos secos","Porcion de frutos secos de 100gr", 150, true);
//Comida alm=new Comida("Carne","Medallon de carne de 150gr", 250, true);
//Comida mer=new Comida("Galletitas con queso descremado","10 galletitas con queso descremado", 200, true);
//Comida cen=new Comida("Pasta","Pasta con oliva y albahaca porcion de 250gr", 350, true);

ComidaData cd= new ComidaData(Conexion.getConnection());
//cd.guardarComida(col);
//cd.guardarComida(des);
//cd.guardarComida(alm);
//cd.guardarComida(cen);
//cd.guardarComida(mer);

//DietaComida dc=new DietaComida(cd.buscarComida(10), dd.buscarDietaPorId(1), Horario.DESAYUNO);
//DietaComida dc1=new DietaComida(cd.buscarComida(12), dd.buscarDietaPorId(1), Horario.ALMUERZO);
//DietaComida dc2=new DietaComida(cd.buscarComida(9), dd.buscarDietaPorId(1), Horario.COLACION);
//DietaComida dc3=new DietaComida(cd.buscarComida(13), dd.buscarDietaPorId(1), Horario.MERIENDA);
//DietaComida dc4=new DietaComida(cd.buscarComida(11), dd.buscarDietaPorId(1), Horario.CENA);

DietaComidaData dcd =new DietaComidaData(Conexion.getConnection());
//dcd.ingresarDietaComida(dc);
//dcd.ingresarDietaComida(dc1);
//dcd.ingresarDietaComida(dc2);
//dcd.ingresarDietaComida(dc3);
//dcd.ingresarDietaComida(dc4);

//Historial histo1= new Historial(pd.buscarPacientePorId(2), dd.buscarDietaPorId(1),85, LocalDate.of(2023, Month.APRIL, 15));
//Historial histo2= new Historial(pd.buscarPacientePorId(2), dd.buscarDietaPorId(1),80, LocalDate.of(2023, Month.MAY, 15));

HistorialData hd=new HistorialData(Conexion.getConnection());
//hd.guardarHistorial(histo2);
//hd.guardarHistorial(histo1);






//LECTURA DE DATOS DE ENTIDADES


        //System.out.println(pd.listarPacientes());

//List <Paciente> lisPac=pd.listarPacientes();
//
//lisPac.forEach(p->{
//    System.out.println(p.getIdPaciente()+ "\n"+p.getDni()+"\n"+p.getApellido()+"\n"+p.getNombre());
//    System.out.println("-----------------------------------------");
//});

        //System.out.println(dcd.listarComidasPorDieta(5));
        
        
       // cd.borrarComida(1);
      Comida com=  cd.buscarComida(1);
        
//        com.setEstado(true);
//        com.setDetalle("2 Porciones de 50 gr.");
//com.setCalorias("200");
        //cd.modificarComida(com);
        
        //System.out.println(hd.buscarHistorialPorId(9));
        //System.out.println(hd.historialPorPaciente(39));
        //System.out.println( cd.buscarComidasPorCalorias("3"));
        
       // System.out.println(dcd.listarComidasPorDieta(5));
        
        //CREACION DE LA LISTA DE DIETAS
        creacionDeLista();
        
        
//LISTA DE DIETAS EN CURSO
        dietaEnCurso();
        //System.out.println("\n");
        //LISTA DE DIETAS CULMINADAS
        dietaTerminada();
        //System.out.println("\n");
        //PACIENTES QUE NO LLEGARON AL PESO REQUERIDO
        //pacientesQueNorpp();
       
       
       
       
       
       
       
         
        
    }
    
    private static void dietaEnCurso(){
    
     System.out.println("Los pacientes con dieta en curso son : ");
       listEstadoEnCurso.forEach(d-> {
           boolean est=d.isEstado();
        String dni=d.getPaciente().getDni();
        String nombre=d.getPaciente().getNombre();
        String apellido =d.getPaciente().getApellido();
         DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String fechaFormateada =d.getFechaFinal().format(formateador);
            System.out.println(nombre +" "+apellido+ " "+dni+" terminaria el : "+fechaFormateada );
            System.out.println("-----------------------------------------------");
        });
    
    
    }
    
    private static void dietaTerminada(){
    
    
    System.out.println("Los pacientes con dieta terminada : ");
       listEstadoTermado.forEach(d-> {
           boolean est=d.isEstado();
        String dni=d.getPaciente().getDni();
        String nombre=d.getPaciente().getNombre();
        String apellido =d.getPaciente().getApellido();
       DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String fechaFormateada =d.getFechaFinal().format(formateador);
            System.out.println(nombre +" "+apellido+ " "+dni+" termino el dia : "+fechaFormateada);
            System.out.println("-----------------------------------------------");
        });
    
    
    
    }
    
    
    private static void pacientesQueNorpp(){
    
     System.out.println("Los pacientes que no llegaron al peso son : ");
        listNorpp.forEach(d-> {
        String dni=d.getPaciente().getDni();
        String nombre=d.getPaciente().getNombre();
        String apellido =d.getPaciente().getApellido();
            System.out.println(nombre +" "+apellido+ " "+dni );
            System.out.println("-----------------------------------------------");
        });
    
    
    
    }
    
    private static void creacionDeLista(){
        DietaData dd=new DietaData(Conexion.getConnection());
     List<Dieta> listTodasDietas = dd.listarDietas();
        listTodasDietas.forEach(d -> {
            double altPac = d.getPaciente().getAltura();
            Map<String, Object> rpp = IMC.calcIMC(altPac);
	
            double pesoFinal = d.getPesoActual();
            if (!(pesoFinal >= (Double)rpp.get("pesoMinimo") && pesoFinal <= (Double)rpp.get("pesoMaximo")) ){
                listNorpp.add(d);
            }
            if (d.isEstado()) {
                listEstadoTermado.add(d);
            } else {
                listEstadoEnCurso.add(d);
            }
        });
        
    
    
    
    }
    
    

}

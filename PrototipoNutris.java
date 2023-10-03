
package prototiponutris;

import AccesoADatos.PacienteData;
import Entidades.Paciente;


public class PrototipoNutris {

   
    public static void main(String[] args) {
        
        Paciente prueba1=new Paciente(1.80, "Carasa 987 ", "4612-1866", "Bolaño","Roberto", 5578967, "1547894215","petruza@yahoo.com.ar");
        PacienteData pac=new PacienteData();
        pac.ingresarPaciente(prueba1);
     
    }
    
}

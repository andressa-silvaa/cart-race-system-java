package entities;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cronometro {

    private int minutos;
    private int segundos;

    
    
   
    public Cronometro(String horario) throws ParseException {
    	
        SimpleDateFormat formato = new SimpleDateFormat("mm:ss");

        Date data = formato.parse(horario);
     
        this.minutos = data.getMinutes();
        this.segundos = data.getSeconds();
   
    }
    
 
    public Cronometro soma(Cronometro outro) throws ParseException {
    	
        int totalMinutos = this.minutos + outro.minutos;
        int totalSegundos = this.segundos + outro.segundos;
        
        
      
        if (totalSegundos >= 60) {
            totalMinutos += totalSegundos / 60;
            totalSegundos %= 60;
        }
       
        Cronometro resultado = new Cronometro("00:00");
        resultado.minutos = totalMinutos;
        resultado.segundos = totalSegundos;
        return resultado;
    }

    @Override
   
    public String toString() {
        DecimalFormat formato = new DecimalFormat("00");
        return formato.format(minutos) + ":" +
                formato.format(segundos);
    }


}
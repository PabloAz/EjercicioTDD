package domain;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ejercicioTDD {
	
	
	private int dia;
	private int mes;
	private int ano; /* La salida ha de tener 4 digitos */
	
	
	public ejercicioTDD() {}

	
	
	public String calcularFecha(String s) throws ParseException{
		
		String[] entrada = s.split("/");
		
		
		if("".equals(s)){
			return "Error";
			
		}else{
			
			entrada = s.split("/");
			if(entrada.length!=3){
				return "Error";
			}
			
			else{
				
				
				try {
					String[] fechasPosibles = generarFechas(entrada);
					List<Calendar> fechas = arrayFechas(fechasPosibles);
					
					if(fechas.size()==0){
						return "Error";
					}else{
						/* Ordenamos el List y devolvemos el primero */
						
						
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "Error";
				}
			
			}
			
		}
		
		return null;
		
	}
	
	
	public List<Calendar> arrayFechas(String[] cadena){
		
		
		List<Calendar> result = new ArrayList<Calendar>();
		
		for(int i=0; i<cadena.length;i++){
			
			try {
				
				String[] cadAux = cadena[i].split("/");
				
				Calendar fecha = Calendar.getInstance();
				fecha.setLenient(false);
				fecha.set(Integer.parseInt(cadAux[2]),Integer.parseInt(cadAux[1])-1, Integer.parseInt(cadAux[0]));
	            
				
				int diaAux = fecha.get(Calendar.DAY_OF_MONTH);
				int mesAux = fecha.get(Calendar.MONTH);
				int anoaux = fecha.get(Calendar.YEAR);
				
				if(diaAux == Integer.parseInt(cadAux[0]) && mesAux == Integer.parseInt(cadAux[1])-1 && +
						anoaux == Integer.parseInt(cadAux[2]) && 1999 < anoaux && anoaux < 3000){
					result.add(fecha);
				}
	     
	            
	        } catch (Exception e) {
	        	System.out.println("Exception en: " + cadena[i] + ". " + e.toString());
	        }
			
		}
		
		return result;
		
		
	}
	
	
	/* Genera un array con todas las fechas posibles */
	public String[] generarFechas(String[] cadena) throws ParseException{
		
		String[] result = new String[6];
		
		String fecha1 = formarFecha(cadena[0], cadena[1], cadena[2]);
		
		String fecha2 = formarFecha(cadena[0], cadena[2], cadena[1]);
		String fecha3 = formarFecha(cadena[1], cadena[0], cadena[2]);
		String fecha4 = formarFecha(cadena[1], cadena[2], cadena[0]);
		String fecha5 = formarFecha(cadena[2], cadena[0], cadena[1]);
		String fecha6 = formarFecha(cadena[2], cadena[1], cadena[0]);
		
		result[0] = fecha1;
		result[1] = fecha2;
		result[2] = fecha3;
		result[3] = fecha4;
		result[4] = fecha5;
		result[5] = fecha6;
		
		return result;
		
	}
	
	
	/* Da formato a los elementos de la fecha */
	public String formarFecha(String dia, String mes, String ano){
		String result = "";
		
		if(dia.length()<2){
			dia = "0"+dia;
		}
		
		if(mes.length()<2){
			mes = "0" + mes;
		}
		
		if(ano.length()==1){
			ano = "200"+ano;
		}
		
		if(ano.length()==2){
			ano = "20"+ano;
		}
		
		result = dia+"/"+mes+"/"+ano;
		return result;
		
	}
	

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}

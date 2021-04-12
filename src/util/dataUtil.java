
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class dataUtil {
	public static List<Date> diasMes(int mes, int ano){
		List<Date> lista = new ArrayList<Date>();
		Calendar calendario = Calendar.getInstance();
		
		calendario.set(Calendar.MONTH, mes);
		calendario.set(Calendar.YEAR, ano);
		int qtdDias = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for (int i = 0; i < qtdDias; i++) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE,i);
			cal.set(Calendar.MONTH, mes);
			cal.set(Calendar.YEAR, ano);
			Date hj = cal.getTime();
			
			lista.add(hj);
		}
		return lista;
	}
	
	public static long diferenca(Date um, Date dois) throws ParseException {
		long secIn = um.getTime();
		long secFi = dois.getTime();
		long dif = (secFi-secIn)/1000;
		
		return dif;
		
	}
	public static Date stringToDate(String data) throws ParseException { 
		Date hj = new SimpleDateFormat("dd/MM/yyyy").parse(data); ;
		return hj;	
	}
	public static String dateToString(Date data) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(data);
	}
	public static String DatehourtoStringhour(Date pDate) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
        String s = "";
        try {
            s = df.format(pDate);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return s;
    }
}
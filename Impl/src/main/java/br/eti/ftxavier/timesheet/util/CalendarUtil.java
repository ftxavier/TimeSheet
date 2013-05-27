package br.eti.ftxavier.timesheet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class CalendarUtil {
	
	private static Logger log = Logger.getLogger(CalendarUtil.class);

	public static Calendar getFirstDayOfMonth(Calendar mes) {
		Calendar mesSelecionado = Calendar.getInstance();
		if(mes!=null) {
			mesSelecionado.setTime(mes.getTime());
		}
		mesSelecionado.set(Calendar.DATE, 1);
		mesSelecionado.set(Calendar.HOUR, 0);
		mesSelecionado.set(Calendar.MINUTE, 0);
		mesSelecionado.set(Calendar.SECOND, 0);
		mesSelecionado.set(Calendar.MILLISECOND, 0);
		return mesSelecionado;
	}

	public static Calendar getLastDayOfMonth(Calendar mes) {
		Calendar mesSelecionado = Calendar.getInstance();
		if(mes!=null) {
			mesSelecionado.setTime(mes.getTime());
			mesSelecionado.set(Calendar.DATE, mes.getActualMaximum(Calendar.DAY_OF_MONTH));
		} else {
			
		}
		mesSelecionado.set(Calendar.HOUR, 23);
		mesSelecionado.set(Calendar.MINUTE, 59);
		mesSelecionado.set(Calendar.SECOND, 59);
		mesSelecionado.set(Calendar.MILLISECOND, 999);
		return mesSelecionado;
	}

	public static Calendar getInstance(String data, String hora) {
		if(data==null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH24:mi:ss");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(format.parse(data + (hora==null?"00:00:00":hora)));
		} catch (ParseException e) {
			log.error("Erro ao converter data: " + data+ " - " + hora, e);
			return null;
		}
		return cal;
	}

}

package br.eti.ftxavier.timesheet.model;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;

import br.eti.ftxavier.timesheet.util.CalendarUtil;

public class RegistroMensal {

	private List<Registro> registros;
	
	private Calendar mesReferencia;

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public Calendar getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(Calendar mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	
	public MutablePeriod getHorasUteis(){
		return CalendarUtil.getHorasUteisMes(getMesReferencia());
	}
	
	public String getHorasUteisAsString() {
		MutablePeriod horasUteis = getHorasUteis();
		if(horasUteis==null) {
			return "00:00";
		} else {
			return StringUtils.leftPad(""+Hours.standardHoursIn(horasUteis).getHours(), 2, "0") 
					+ ":" 
					+ StringUtils.leftPad(""+(Minutes.standardMinutesIn(horasUteis).getMinutes()%60), 2, "0");
		}
	}

	public MutablePeriod getTotalHorasTrabalhadas() {
		MutablePeriod mutablePeriod = new MutablePeriod();
		for (Registro registro : this.getRegistros()) {
			mutablePeriod.add(registro.getPeriod());
		}
		return mutablePeriod;
	}
	
	public Period getSaldoHoras() {
		Period total = new Period(getTotalHorasTrabalhadas());
		Period saldo = total.minus(getHorasUteis());
		return saldo;
	}
	
	public String getSaldoHorasAsString() {
		Period saldo = getSaldoHoras();
		if(saldo==null) {
			return "00:00";
		} else {
			return StringUtils.leftPad(""+Hours.standardHoursIn(saldo).getHours(), 2, "0") 
					+ ":" 
					+ StringUtils.leftPad(""+(Minutes.standardMinutesIn(saldo).getMinutes()%60), 2, "0");
		}
	}

	@Override
	public String toString() {
		MutablePeriod total = getTotalHorasTrabalhadas();
		if(total!=null) {
			return StringUtils.leftPad(""+Hours.standardHoursIn(total).getHours(), 2, "0") 
					+ ":" 
					+ StringUtils.leftPad(""+(Minutes.standardMinutesIn(total).getMinutes()%60), 2, "0");
		} else {
			return "00:00";
		}
	}
}

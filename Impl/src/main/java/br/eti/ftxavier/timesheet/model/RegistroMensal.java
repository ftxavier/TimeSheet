package br.eti.ftxavier.timesheet.model;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.MutablePeriod;

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

	public MutablePeriod getTotalHorasTrabalhadas() {
		MutablePeriod mutablePeriod = new MutablePeriod();
		for (Registro registro : this.getRegistros()) {
			mutablePeriod.add(registro.getPeriod());
		}
		return mutablePeriod;
	}

	@Override
	public String toString() {
		if(getTotalHorasTrabalhadas()!=null) {
			return StringUtils.leftPad(""+Hours.standardHoursIn(getTotalHorasTrabalhadas()).getHours(), 2, "0") + ":" + StringUtils.leftPad(""+(Minutes.standardMinutesIn(getTotalHorasTrabalhadas()).getMinutes()%60), 2, "0");
		} else {
			return "00:00";
		}
	}
}

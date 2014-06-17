package br.eti.ftxavier.timesheet.model;

import java.util.Calendar;
import java.util.List;

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
	
	public Period getHorasUteis(){
		Period period = new Period().withHours(CalendarUtil.getHorasUteisMes(getMesReferencia()));
		return period;
	}
	
	public Period getTotalHorasTrabalhadas() {
		Period period = new Period();
		for (Registro registro : this.getRegistros()) {
			period.sum(registro.getPeriod());
		}
		return period;
	}
	
	public Period getSaldoHoras() {
		Period total = getTotalHorasTrabalhadas();
		Period saldo = total.minus(getHorasUteis());
		return saldo;
	}
	
	@Override
	public String toString() {
		return getTotalHorasTrabalhadas().toString();
	}
}

package br.eti.ftxavier.timesheet.model;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

public class Period {
	
	private long millis;
	
	public Integer getHours() {
		return 0;
	}
	
	public Integer getMinutes() {
		return 0;
	}
	
	public Integer getDays() {
		return 0;
	}
	
	public long getMillis() {
		return millis;
	}

	public Period sum(Period period) {
		withMillis(getMillis()+period.getMillis());
		return this;
	}

	public Period withHours(Integer hours) {
		this.millis = TimeUnit.HOURS.toMillis(hours);
		return this;
	}

	public Period minus(Period subtraend) {
		withMillis(getMillis()-subtraend.getMillis());
		return this;
	}
	
	private Period withMillis(long millis) {
		this.millis = millis;
		return this;
	}

	@Override
	public String toString() {
		long minutes = (TimeUnit.MINUTES.convert(getMillis(), TimeUnit.MILLISECONDS)%60);
		long hours = TimeUnit.HOURS.convert(getMillis(), TimeUnit.MILLISECONDS); 
		return hours + ":" + StringUtils.leftPad(String.valueOf(minutes<0?(minutes*-1):minutes), 2, "0");
	}

	public Period between(Calendar entrada, Calendar saida) {
		this.millis = (saida.getTimeInMillis()-entrada.getTimeInMillis());
		return this;
	}
}

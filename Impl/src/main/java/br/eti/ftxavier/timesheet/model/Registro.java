package br.eti.ftxavier.timesheet.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Period;

@Entity
public class Registro implements Serializable {
	
	private static final long serialVersionUID = -2683458198588267875L;
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_entrada")
	private Calendar entrada;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_saida")
	private Calendar saida;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getEntrada() {
		return entrada;
	}
	public void setEntrada(Calendar entrada) {
		this.entrada = entrada;
	}
	public Calendar getSaida() {
		return saida;
	}
	public void setSaida(Calendar saida) {
		this.saida = saida;
	}
	
	public Period getPeriod() {
		if(getEntrada()!=null && getSaida()!=null)
			return new Period(getEntrada().getTimeInMillis(), getSaida().getTimeInMillis());
		else
			return new Period();
	}
	
	public String getHorasTrabalhadas() {
		if(getPeriod()!=null)
			return StringUtils.leftPad(""+Hours.standardHoursIn(getPeriod()).getHours(), 2, "0") + ":" + StringUtils.leftPad(""+(Minutes.standardMinutesIn(getPeriod()).getMinutes()%60), 2, "0"); 
		else return null;
	}
}

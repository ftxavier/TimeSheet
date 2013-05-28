package br.eti.ftxavier.timesheet.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
	@Column(name="data_hora_saida")
	private Calendar saida;
	@Column(name="total_horas")
	private BigDecimal totalHorasTrabalhadas;
	
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
	public BigDecimal getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}
	public void setTotalHorasTrabalhadas(BigDecimal totalHorasTrabalhadas) {
		this.totalHorasTrabalhadas = totalHorasTrabalhadas;
	}
	
}

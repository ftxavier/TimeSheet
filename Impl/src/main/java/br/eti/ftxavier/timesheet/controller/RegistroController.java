package br.eti.ftxavier.timesheet.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.service.RegistroService;
import br.eti.ftxavier.timesheet.util.CalendarUtil;
import br.eti.ftxavier.timesheet.util.UserSession;

@Resource
@Path("/registro")
public class RegistroController {
	
	@Autowired
	private RegistroService registroService;
	
	private UserSession userSession; 
	
	private Result result;
	
	public RegistroController(UserSession userSession, Result result) {
		this.userSession = userSession;
		this.result = result;
	}
	
	@Path("/")
	public List<Registro> list() {
		return registroService.getRegistroByMonth(Calendar.getInstance(), userSession.getUsuario());
	}
	
	@Path("/new")
	public Registro novo() {
		return new Registro();
	}
	
	@Path("/{registro.id}/edit")
	public Registro edit(Registro registro) {
		return registroService.findById(registro.getId());
	}
	
	@Path("/add")
	public void add(String data, String entrada, String saida) {
		Calendar horaEntrada = CalendarUtil.getInstance(data, entrada);
		Calendar horaSaida = CalendarUtil.getInstance(data, saida);
		Registro registro = new Registro();
		registro.setEntrada(horaEntrada);
		registro.setSaida(horaSaida);
		registro.setUsuario(userSession.getUsuario());
		registroService.save(registro);
		result.redirectTo(this.getClass()).list();
	}

}

package br.eti.ftxavier.timesheet.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sun.util.calendar.CalendarUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.model.enumerations.TipoRegistro;
import br.eti.ftxavier.timesheet.service.RegistroService;
import br.eti.ftxavier.timesheet.util.CalendarUtil;
import br.eti.ftxavier.timesheet.util.UserSession;

@Resource
@Path("/registro")
public class RegistroController {
	
	@Autowired
	private RegistroService registroService;
	
	private UserSession userSession; 
	
	public RegistroController(UserSession userSession) {
		this.userSession = userSession;
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
	
	public void add(String data, String hora) {
		Calendar dataHora = CalendarUtil.getInstance(data, hora);
		Registro registro = new Registro();
		registro.setDataHora(dataHora);
		registro.setUsuario(userSession.getUsuario());
		registro.setTipoRegistro(TipoRegistro.ENTRADA);
	}

}

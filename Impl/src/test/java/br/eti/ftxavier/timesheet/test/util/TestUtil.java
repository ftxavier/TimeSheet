package br.eti.ftxavier.timesheet.test.util;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.service.UsuarioService;
import br.eti.ftxavier.timesheet.util.CalendarUtil;

@Component
public class TestUtil {
	
	@Autowired
	private UsuarioService usuarioService; 

	public Usuario getUsuario(String login) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setName("Nome");
		usuario.setPassword("senha");
		return usuario;
	}
	
	public Registro getRegistro(Usuario usuario) {
		return getRegistro(CalendarUtil.getInstance("01/01/2013", "09:00"), CalendarUtil.getInstance("01/01/2013", "12:00"), usuario);
	}
	
	public Registro getRegistro(Calendar entrada, Calendar saida, Usuario usuario) {
		Registro registro = new Registro();
		registro.setEntrada(entrada);
		registro.setSaida(saida);
		if(usuario==null)
			registro.setUsuario(getPersistedUsuario("ftxavier"));
		else
			registro.setUsuario(usuario);
		return registro;
	}

	public Usuario getPersistedUsuario(String login) {
		Usuario usuario = usuarioService.getUsuarioByLogin(login);
		if(usuario==null)
			usuario = persistUsuario(login);
		return usuario;
	}

	private Usuario persistUsuario(String login) {
		Usuario usuario = getUsuario(login);
		usuarioService.save(usuario);
		return usuario;
	}
}

package br.eti.ftxavier.timesheet.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.service.UsuarioService;

@Component
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = -260645656120779715L;

	private Usuario usuario;

	@Autowired
	private UsuarioService usuarioService;

	public Usuario getUsuario() {
		if (usuario == null) {
			User user = (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (user != null)
				usuario = usuarioService.getUsuarioByLogin(user.getUsername());
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}

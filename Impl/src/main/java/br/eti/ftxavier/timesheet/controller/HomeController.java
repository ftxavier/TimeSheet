package br.eti.ftxavier.timesheet.controller;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.eti.ftxavier.timesheet.util.UserSession;

@Resource
@Path("/")
public class HomeController {
	
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	private UserSession userSession;

	public HomeController(UserSession userSession) {
		this.userSession = userSession;
	}

	@Get
	@Path("/")
	public String index() {
		return "Hello " + userSession.getUsuario().getName();
	}
	
	@Get @Path("/403")
	public void denied() {
		log.info("Usuario " + (userSession.getUsuario()==null?"":userSession.getUsuario().getLogin()) + " não possui permissão para acessar a página.");
	}
	
}

package br.eti.ftxavier.timesheet.controller;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.service.UsuarioService;

@Resource
@Path("/login")
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Result result;
	private Validator validator;
	
	public LoginController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
    }

	@Get @Path("")
	public void login() {
		
	}
	
	@Get @Path("/error")
	public void error() {
		result.include("error", Boolean.TRUE);
		result.forwardTo(LoginController.class).login();
	}
	
	@Get @Path("/esqueci")
	public void esqueci() {
		
	}
	
	@Post @Path("/reset")
	public void reset(String email){
		if (email == null) {
	        validator.add(new ValidationMessage("email.nao.informado", "erro"));
	    }
		Usuario usuario = usuarioService.findByEmail(email);
		if (usuario == null) {
	        validator.add(new ValidationMessage("email.nao.encontrado", "erro"));
	    }
		
		validator.onErrorUsePageOf(this).esqueci();
		usuarioService.sendResetPasswordEmail(usuario);
		result.include("mensagem", ResourceBundle.getBundle("messages").getString("mensagem.email.reset.enviado"));
		result.redirectTo(this).login();
	}
}

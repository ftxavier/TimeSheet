package br.eti.ftxavier.timesheet.test.util;

import br.eti.ftxavier.timesheet.model.Usuario;

public class TestUtil {

	public static Usuario getUsuario(String login) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome("Nome");
		usuario.setSenha("senha");
		return usuario;
	}
}

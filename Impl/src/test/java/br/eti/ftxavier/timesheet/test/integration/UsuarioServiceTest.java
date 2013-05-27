package br.eti.ftxavier.timesheet.test.integration;

import static org.junit.Assert.assertNotNull;
import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.service.UsuarioService;
import br.eti.ftxavier.timesheet.test.util.TestUtil;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:beans/application-context-test.xml", "classpath*:beans/data-context-test.xml" } )
public class UsuarioServiceTest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TestUtil testUtil;
		
	@Test
	public void save() {
		Usuario usuario = testUtil.getUsuario("usuariosave");
		usuarioService.save(usuario);
		assertNotNull(usuario.getId());
	}
	
	@Test
	public void list() {
		save();
		List<Usuario> lista = usuarioService.list();
		notEmpty(lista);
	}
	
	@Test
	public void findByLogin() {
		Usuario usuario = testUtil.getUsuario("ftxavier");
		usuarioService.save(usuario);
		Usuario usuarioSalvo = usuarioService.getUsuarioByLogin("ftxavier");
		assertNotNull(usuarioSalvo);
	}

}

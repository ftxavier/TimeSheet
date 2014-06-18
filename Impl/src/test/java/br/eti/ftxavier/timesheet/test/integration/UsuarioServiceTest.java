package br.eti.ftxavier.timesheet.test.integration;

import static org.junit.Assert.*;
import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.util.AssertException;

import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.service.UsuarioService;
import br.eti.ftxavier.timesheet.test.util.TestUtil;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:applicationContext-test.xml" } )
public class UsuarioServiceTest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TestUtil testUtil;
		
	@Test
	public void save() {
		Usuario usuario = testUtil.getUsuario("user-sevice-test");
		usuarioService.save(usuario);
		assertNotNull(usuario.getId());
	}
	
	@Test
	public void list() {
		Usuario usuario = testUtil.getUsuario("user-sevice-test-list");
		usuarioService.save(usuario);
		List<Usuario> lista = usuarioService.list();
		assertNotNull(lista);
		assertEquals(1, lista.size());
	}
	
	@Test
	public void findByLogin() {
		Usuario usuario = testUtil.getUsuario("ftxavier");
		usuarioService.save(usuario);
		Usuario usuarioSalvo = usuarioService.getUsuarioByLogin("ftxavier");
		assertNotNull(usuarioSalvo);
	}

}

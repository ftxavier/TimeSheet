package br.eti.ftxavier.timesheet.test.unit;

import static org.junit.Assert.assertNotNull;
import static org.springframework.util.Assert.notEmpty;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.eti.ftxavier.timesheet.dao.UsuarioDao;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.test.util.TestUtil;

@Transactional
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:applicationContext-test.xml" } )
public class UsuarioDaoTest {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private TestUtil testUtil;
	
	@Test
	public void save() {
		Usuario usuario = testUtil.getUsuario("fernando");
		usuarioDao.save(usuario);
		assertNotNull(usuario.getId());
	}
	
	@Test
	public void list() {
		save();
		List<Usuario> lista = usuarioDao.findAll();
		notEmpty(lista);
	}
}

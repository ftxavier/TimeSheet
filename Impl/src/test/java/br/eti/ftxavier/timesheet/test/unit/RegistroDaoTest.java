package br.eti.ftxavier.timesheet.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.eti.ftxavier.timesheet.dao.RegistroDao;
import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.test.util.TestUtil;
import br.eti.ftxavier.timesheet.util.CalendarUtil;

@Transactional
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:applicationContext-test.xml" } )
public class RegistroDaoTest {
	
	@Autowired
	private RegistroDao registroDao;
	
	@Autowired
	private TestUtil testUtil;
	
	@Before
	public void prepare() {
		registroDao.save(testUtil.getRegistro(CalendarUtil.getInstance("01/01/2013", "09:00"), CalendarUtil.getInstance("01/01/2013", "12:00:00"), testUtil.getPersistedUsuario("ftxavier")));
		registroDao.save(testUtil.getRegistro(CalendarUtil.getInstance("01/01/2013", "13:00"), CalendarUtil.getInstance("01/01/2013", "18:00:00"), testUtil.getPersistedUsuario("ftxavier")));
	}
	
	@Test
	public void test_get_last_registro() {
		Registro ultimo = registroDao.getLastRegistro(testUtil.getPersistedUsuario("ftxavier"));
		assertNotNull(ultimo);
		assertEquals("01/01/2013 18:00", CalendarUtil.toString(ultimo.getSaida()));
	}
	
	@Test
	public void test_get_registros_usuario_between_dates() {
		Calendar firstDay = CalendarUtil.getFirstDayOfMonth(CalendarUtil.getInstance("01/01/2013"));
		Calendar lastDay = CalendarUtil.getLastDayOfMonth(CalendarUtil.getInstance("01/01/2013"));
		List<Registro> lista = registroDao.getRegistrosBetweenDates(firstDay, lastDay, testUtil.getPersistedUsuario("ftxavier"));
		assertNotNull(lista);
		assertEquals(2, lista.size());
	}

}

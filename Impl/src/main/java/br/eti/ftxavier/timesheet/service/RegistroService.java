package br.eti.ftxavier.timesheet.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.eti.ftxavier.timesheet.dao.RegistroDao;
import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.model.RegistroMensal;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.util.CalendarUtil;

@Service
public class RegistroService {

	@Autowired
	private RegistroDao registroDao;
	
	@Transactional
	public void save(Registro registro) {
		registroDao.save(registro);
	}

	public List<Registro> getRegistroByMonth(Calendar mes, Usuario usuario) {
		Calendar firstDayOfMonth = CalendarUtil.getFirstDayOfMonth(mes);
		Calendar lastDayOfMonth = CalendarUtil.getLastDayOfMonth(mes);
		return registroDao.getRegistrosBetweenDates(firstDayOfMonth, lastDayOfMonth, usuario);
	}

	public Registro findById(Long id) {
		return registroDao.findById(id);
	}
	
	public Registro getLastregistro(Usuario usuario) {
		return registroDao.getLastRegistro(usuario);
	}

	public RegistroMensal montaRegistroMensal(Calendar mes, Usuario usuario) {
		RegistroMensal registroMensal = new RegistroMensal();
		registroMensal.setRegistros(this.getRegistroByMonth(mes, usuario));
		registroMensal.setMesReferencia(CalendarUtil.getFirstDayOfMonth(mes));
		return registroMensal;
	}

	@Transactional
	public void remove(Registro registro) {
		registroDao.remove(findById(registro.getId()));
	}
}

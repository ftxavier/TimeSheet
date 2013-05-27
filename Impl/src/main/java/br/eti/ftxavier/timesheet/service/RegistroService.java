package br.eti.ftxavier.timesheet.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.ftxavier.timesheet.dao.RegistroDao;
import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.model.Usuario;
import br.eti.ftxavier.timesheet.util.CalendarUtil;

@Service
public class RegistroService implements Serializable{

	private static final long serialVersionUID = 7714462687694034427L;

	@Autowired
	private RegistroDao registroDao;
	
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
}

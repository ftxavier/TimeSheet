package br.eti.ftxavier.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.ftxavier.timesheet.dao.RegistroDao;
import br.eti.ftxavier.timesheet.model.Registro;

@Service
public class RegistroService {

	@Autowired
	private RegistroDao registroDao;
	
	public void save(Registro registro) {
		registroDao.save(registro);
	}
}

package br.eti.ftxavier.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.eti.ftxavier.timesheet.dao.UsuarioDao;
import br.eti.ftxavier.timesheet.model.Usuario;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Usuario getUsuarioByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}
	
	@Transactional
	public List<Usuario> list() {
		return usuarioDao.findAll();
	}
	
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public Usuario findById(Long identifier) {
		return usuarioDao.findById(identifier);
	}
}

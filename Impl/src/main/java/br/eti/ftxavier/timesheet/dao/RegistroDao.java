package br.eti.ftxavier.timesheet.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.eti.ftxavier.timesheet.model.Registro;
import br.eti.ftxavier.timesheet.model.Usuario;

@Repository
public class RegistroDao extends AbstractDao<Registro, Long> {

	@SuppressWarnings("unchecked")
	public List<Registro> getRegistrosBetweenDates(Calendar firstDayOfMonth, Calendar lastDayOfMonth, Usuario usuario) {
		Criteria crit = getCurrentSession().createCriteria(Registro.class);
		crit.add(Restrictions.ge("dataHora", firstDayOfMonth))
			.add(Restrictions.le("dataHora", lastDayOfMonth))
			.add(Restrictions.eq("usuario", usuario));
		return (List<Registro>)crit.list();
	}

	public Registro getLastRegistro(Usuario usuario) {
		Criteria crit = getCurrentSession().createCriteria(Registro.class);
		crit.add(Restrictions.eq("usuario", usuario))
			.addOrder(Order.desc("dataHora"))
			.setMaxResults(1);
		return (Registro)crit.uniqueResult();
	}

}

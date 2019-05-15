package app.dao.impl;

import app.dao.BasicCrudDao;
import app.entities.Notification;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NotificationDaoImpl implements BasicCrudDao<Notification> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Notification notification) {
		sessionFactory.getCurrentSession().save(notification);
	}

	@Override
	public void update(Notification notification) {
		sessionFactory.getCurrentSession().update(notification);
	}

	@Override
	public Notification findById(int id) {
		Notification notification = sessionFactory.getCurrentSession().get(Notification.class, id);
		return notification;
	}

	@Override
	public List<Notification> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Notification");
		return query.getResultList();

	}

	@Override
	public void deleteById(int id) {
		sessionFactory.getCurrentSession().delete(findById(id));
	}

	@Override
	public void delete(Notification notification) {
		sessionFactory.getCurrentSession().delete(notification);
	}


}

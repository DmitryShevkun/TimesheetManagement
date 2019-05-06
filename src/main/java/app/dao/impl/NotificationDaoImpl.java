package app.dao.impl;

import app.dao.BasicCrudDao;
import app.entities.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@Transactional
public class NotificationDaoImpl implements BasicCrudDao<Notification> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Notification notification) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(notification);
	    session.getTransaction().commit();
	    session.close();
	}

	@Override
	public void update(Notification notification) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.update(notification);
	    session.getTransaction().commit();
	    session.close();
	}

	@Override
	public Notification findById(int id) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    Notification notification = session.get(Notification.class, id);
	    if (notification == null) {
	        throw new NoSuchElementException("No such notification");
        }
	    session.getTransaction().commit();
	    session.close();
		return notification;
	}

	@Override
	public List<Notification> findAll() {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    List<Notification> notifications = session.createQuery("from Notification").getResultList();
	    session.getTransaction().commit();
	    session.close();
		return notifications;

	}

	@Override
	public void deleteById(int id) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.delete(findById(id));
	    session.getTransaction().commit();
	    session.close();
	}

	@Override
	public void delete(Notification notification) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.delete(notification);
	    session.getTransaction().commit();
	    session.close();
	}


}

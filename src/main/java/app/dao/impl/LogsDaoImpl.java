package app.dao.impl;

import app.dao.BasicCrudDao;
import app.entities.Log;
import app.exceptions.EntityNotFoundException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LogsDaoImpl implements BasicCrudDao<Log> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Log findById(int id) {
        Log logs = sessionFactory.getCurrentSession().get(Log.class, id);
        if (logs == null) {
            throw new EntityNotFoundException();
        }
        return logs;
    }

    @Override
    public List<Log> findAll() {
        Query query
                = sessionFactory.getCurrentSession()
                .createQuery("from app.entities.Log");
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public void create(Log entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void delete(Log entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void update(Log entity) {
        sessionFactory.getCurrentSession().update(entity);
    }
}

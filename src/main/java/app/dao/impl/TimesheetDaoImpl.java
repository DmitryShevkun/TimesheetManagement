package app.dao.impl;

import app.dao.BasicCrudDao;
import app.entities.Timesheet;
import app.exceptions.EntityNotFoundException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TimesheetDaoImpl implements BasicCrudDao<Timesheet> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Timesheet findById(int id) {
        Timesheet timesheet = sessionFactory.getCurrentSession().get(Timesheet.class, id);
        if (timesheet == null) {
            throw new EntityNotFoundException();
        }
        return timesheet;
    }

    @Override
    public List<Timesheet> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Timesheet");
        return query.getResultList();
    }

    @Override
    public void create(Timesheet entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void delete(Timesheet entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public void update(Timesheet entity) {
        sessionFactory.getCurrentSession().update(entity);
    }
}

package app.dao.impl;

import app.dao.BasicCrudDao;
import app.entities.Assignment;
import app.exceptions.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AssignmentDaoImpl implements BasicCrudDao<Assignment> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Assignment findById(int id) {
        Assignment assignment = sessionFactory.getCurrentSession()
                .get(Assignment.class, id);
        if (assignment == null) {
            throw new EntityNotFoundException();
        }
        return assignment;
    }

    @Override
    public List<Assignment> findAll() {
        Query query
                = sessionFactory.getCurrentSession()
                .createQuery("from Assignment");
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Assignment assignment = session.load(Assignment.class, id);
        session.delete(assignment);
    }

    @Override
    public void create(Assignment entity) {
        sessionFactory.getCurrentSession()
                .save(entity);
    }

    @Override
    public void delete(Assignment entity) {
        sessionFactory.getCurrentSession()
                .delete(entity);
    }

    @Override
    public void update(Assignment entity) {
        sessionFactory.getCurrentSession()
                .update(entity);
    }
}

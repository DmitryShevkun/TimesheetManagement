package app.dao.impl;

import app.entities.Company;
import app.dao.BasicCrudDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements BasicCrudDao<Company> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public synchronized List<Company> findAll(){
        List<Company> companies = (List<Company>)
                sessionFactory.getCurrentSession().createQuery("From Company").list();
        return companies;
    }

    @Override
    public synchronized Company findById(int id) {
        return sessionFactory.getCurrentSession().get(Company.class, id);
    }

    @Override
    public synchronized void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public void create(Company company) {
        sessionFactory.getCurrentSession().save(company);
    }

    @Override
    public void delete(Company company) {
        sessionFactory.getCurrentSession().delete(company);
    }

    @Override
    public void update(Company company) {
        sessionFactory.getCurrentSession().update(company);
    }
}


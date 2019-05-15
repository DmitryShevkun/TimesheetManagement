package app.dao.impl;

import app.config.beans.DaoConfig;
import app.config.beans.HibernateConfig;
import app.config.beans.PropertyConfig;
import app.dao.BasicCrudDao;
import app.entities.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PropertyConfig.class, DaoConfig.class, HibernateConfig.class})
public class LogsDaoImplTest {

    @Autowired
    BasicCrudDao<Log> l;

    @Test
    public void testDelete() {
        l.deleteById(1);
    }

    @Test
    public void testFindAll() {
        System.out.println(l.findAll());
    }

    @Test
    public void testFindId() {
        System.out.println(l.findById(2));
    }
}
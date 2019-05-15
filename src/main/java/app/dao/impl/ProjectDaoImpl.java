package app.dao.impl;

import app.dao.BasicCrudDao;
import app.dao.ProjectDao;
import app.entities.*;
import app.exceptions.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private BasicCrudDao<Assignment> assignmentBasicCrudDao;
    @Autowired
    private BasicCrudDao<Project> projectBasicCrudDao;
    @Autowired
    private ProjectDao logsProjectDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Project findById(int id) {
        Project project = sessionFactory.getCurrentSession().get(Project.class, id);
        if (project == null) {
            throw new EntityNotFoundException();
        }
        return project;
    }

    @Override
    public List<Project> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Project");
        return query.getResultList();
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.load(Project.class, id);
        session.delete(project);
    }

    @Override
    public void create(Project entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void delete(Project entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void update(Project entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public Project findByAssignmentId(int id) {
        Project project = (Project) sessionFactory.getCurrentSession().createQuery("select id from Log as log join Assignment as assign on log.assignmentId = assign.id");
        return project;
    }

    public long countActualProjectTime() {
        List<Assignment> assignments = assignmentBasicCrudDao.findAll();
        long sumLogs = 0;
        for (Assignment assign : assignments) {
            List<Log> logs = (List<Log>) logsProjectDao.findByAssignmentId(assign.getId());
            for (Log log : logs) {
                sumLogs += log.getTime();
            }
        }
        return sumLogs;
    }

    @Override
    public List<Employee> getProjectTeam() {
        List<Project> projects = projectBasicCrudDao.findAll();
        List<Employee> projectTeamList = new LinkedList<>();
        List<Employee> projectTeam = (List<Employee>) sessionFactory.getCurrentSession().createQuery("select employeeId from Assignment as assign join Project as proj on assign.projectId = proj.id");
        for (int i = 0; i < projects.size(); i++) {
            projectTeamList.addAll(projectTeam);
        }
        return projectTeamList;
    }

    @Override
    public List<ProjectPage> getProjectData() {
        List<ProjectPage> projectPageList = new LinkedList<>();
        List<Project> projects = projectBasicCrudDao.findAll();
        ProjectPage projectPage = null;
        for (int i = 0; i < projects.size(); i++) {
            projectPage.setProjectColor(projects.get(i).getColor());
            projectPage.setProjectName(projects.get(i).getName());
            projectPage.setProjectCode(projects.get(i).getCode());
            projectPage.setProjectStartDate(projects.get(i).getStartDate());
            projectPage.setTeam(getProjectTeam());
            projectPage.setProjectLoading(countActualProjectTime());
            projectPageList.add(projectPage);
        }
        return projectPageList;
    }
}





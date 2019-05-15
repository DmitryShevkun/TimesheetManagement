package app.config.beans;


import app.dao.*;
import app.dao.impl.*;
import app.entities.Assignment;
import app.entities.Company;
import app.entities.Invitation;
import app.entities.Log;
import app.entities.Timesheet;
import app.entities.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public BasicCrudDao<Company> getCompanyDao() {
        return new CompanyDaoImpl();
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

    @Bean
    public BasicCrudDao<Log> getLogsDao() {
        return new LogsDaoImpl();
    }

    @Bean
    public BasicCrudDao<Project> getProjectDao() {
        return new ProjectDaoImpl();
    }

    @Bean
    public BasicCrudDao<Invitation> getInvitationDao(){
        return new InvitationDaoImpl();
    }

    @Bean
    public BasicCrudDao<Assignment> getAssignmentDao() {
        return new AssignmentDaoImpl();
    }

    @Bean
    public NotificationDaoImpl getNotificationDao() {
        return new NotificationDaoImpl();
    }

    @Bean
    public BasicCrudDao<Timesheet> getTimesheetDao() {
        return new TimesheetDaoImpl();
    }

}

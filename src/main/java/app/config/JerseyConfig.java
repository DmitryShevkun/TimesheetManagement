package app.config;

import app.resources.*;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/*")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CompanyResource.class);
        register(EmployeeResource.class);
        register(LogsResource.class);
        register(ProjectResource.class);
        register(AssignmentResource.class);
        register(ProjectVersionResource.class);
        register(NotificationResource.class);
        register(InvitationResource.class);
        register(TimesheetResource.class);
    }
}

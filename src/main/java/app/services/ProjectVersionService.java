package app.services;

import app.entities.ProjectVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProjectVersionService {

    @Value("${version}")
    String version;

    public ProjectVersion getProjectVersion() {
        return new ProjectVersion(version);
    }
}

package app.dao;

import app.entities.Log;
import app.entities.namespace.LogsNamespace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsDao {

    List<Log> getLogFor(LogsNamespace logsNamespace);

    List<Log> getAll();

    void save(Log logs);

    void delete(Log logs);
}

package app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Timesheet")
public class Timesheet {
    @Id
    private int id;
    private int periodId;
    private String timesheetJson;
    private String status;

    public Timesheet() {
    }

    public Timesheet(int id, int periodId, String timesheetJson, String status) {
        this.id = id;
        this.periodId = periodId;
        this.timesheetJson = timesheetJson;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public String getTimesheetJson() {
        return timesheetJson;
    }

    public void setTimesheetJson(String timesheetJson) {
        this.timesheetJson = timesheetJson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

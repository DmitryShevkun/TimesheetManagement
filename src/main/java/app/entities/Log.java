package app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    private int id;
    private int assignmentId;
    private double time;
    private int order;
    private String comment;
    private Date date;

    public Log() {
    }

    public Log(int id, int assignmentId, double time, int order,
               String comment, Date date) {
        this.id = id;
        this.assignmentId = assignmentId;
        this.time = time;
        this.order = order;
        this.comment = comment;
        this.date = date;
    }

    public Log(int assignmentId, double time, int order, String comment, Date date) {
        this.assignmentId = assignmentId;
        this.time = time;
        this.order = order;
        this.comment = comment;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Log logs = (Log) object;
        return id == logs.id &&
                assignmentId == logs.assignmentId &&
                Double.compare(logs.time, time) == 0 &&
                order == logs.order &&
                Objects.equals(comment, logs.comment) &&
                Objects.equals(date, logs.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignmentId, time, order, comment, date);
    }

    @Override
    public String toString() {
        return "Log{"
                + "assignmentId: " + assignmentId + ';'
                + "order: " + order + ';'
                + " time: " + time + ';'
                + "comment: '" + comment + '\''
                + " Date: " + date + ';'
                + '}';
    }
}

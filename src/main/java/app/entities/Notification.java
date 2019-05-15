package app.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table (name = "Notification")
public class Notification {

    @Id
    private int id;
    private Date createdAt;
    private int employeeId;
    private String status;
    private String title;
    private String description;
    private String link;

    public Notification() {
    }

    public Notification(int id, int employeeId, String status, String title, String description, String link) {
        this.id = id;
        this.employeeId = employeeId;
        this.status = status;
        this.title = title;
        this.description = description;
        this.link = link;
    }

    @PrePersist
    protected void onCreate() {
    	createdAt = new Timestamp(new java.util.Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
    	createdAt = new Timestamp(new java.util.Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

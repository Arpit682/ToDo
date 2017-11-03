package module.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    String taskDescription;
    String taskStatus;
    Date creationDate;
    Date completionDate;

    public Task() {}

    public Task(String taskDescription, String taskStatus, Date creationDate, Date completionDate) {
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}

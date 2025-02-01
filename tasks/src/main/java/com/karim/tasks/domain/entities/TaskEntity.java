package com.karim.tasks.domain.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    private Date dueDate;

    @Column(nullable = false)
    private TaskPriority priority;

    @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id")
    private TaskListEntity taskList;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    public TaskEntity(UUID id, String title, String description, Date dueDate, TaskPriority priority, TaskStatus status, TaskListEntity taskList, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.taskList = taskList;
        this.created = created;
        this.updated = updated;
    }

    public TaskEntity() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public TaskPriority getPriority() {
        return this.priority;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public TaskListEntity getTaskList() {
        return this.taskList;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public LocalDateTime getUpdated() {
        return this.updated;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setTaskList(TaskListEntity taskList) {
        this.taskList = taskList;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskEntity)) return false;
        final TaskEntity other = (TaskEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$dueDate = this.getDueDate();
        final Object other$dueDate = other.getDueDate();
        if (this$dueDate == null ? other$dueDate != null : !this$dueDate.equals(other$dueDate)) return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$taskList = this.getTaskList();
        final Object other$taskList = other.getTaskList();
        if (this$taskList == null ? other$taskList != null : !this$taskList.equals(other$taskList)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$updated = this.getUpdated();
        final Object other$updated = other.getUpdated();
        if (this$updated == null ? other$updated != null : !this$updated.equals(other$updated)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $dueDate = this.getDueDate();
        result = result * PRIME + ($dueDate == null ? 43 : $dueDate.hashCode());
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $taskList = this.getTaskList();
        result = result * PRIME + ($taskList == null ? 43 : $taskList.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $updated = this.getUpdated();
        result = result * PRIME + ($updated == null ? 43 : $updated.hashCode());
        return result;
    }

    public String toString() {
        return "TaskEntity(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", dueDate=" + this.getDueDate() + ", priority=" + this.getPriority() + ", status=" + this.getStatus() + ", taskList=" + this.getTaskList() + ", created=" + this.getCreated() + ", updated=" + this.getUpdated() + ")";
    }
}

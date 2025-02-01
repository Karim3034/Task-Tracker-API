package com.karim.tasks.domain.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task_lists")
public class TaskListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TaskEntity> tasks;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;

    public TaskListEntity(UUID id, String title, String description, List<TaskEntity> tasks, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.created = created;
        this.updated = updated;
    }

    public TaskListEntity() {
    }

    public static TaskListEntityBuilder builder() {
        return new TaskListEntityBuilder();
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

    public List<TaskEntity> getTasks() {
        return this.tasks;
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

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskListEntity)) return false;
        final TaskListEntity other = (TaskListEntity) o;
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
        final Object this$tasks = this.getTasks();
        final Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$updated = this.getUpdated();
        final Object other$updated = other.getUpdated();
        if (this$updated == null ? other$updated != null : !this$updated.equals(other$updated)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskListEntity;
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
        final Object $tasks = this.getTasks();
        result = result * PRIME + ($tasks == null ? 43 : $tasks.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $updated = this.getUpdated();
        result = result * PRIME + ($updated == null ? 43 : $updated.hashCode());
        return result;
    }

    public String toString() {
        return "TaskListEntity(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", tasks=" + this.getTasks() + ", created=" + this.getCreated() + ", updated=" + this.getUpdated() + ")";
    }

    public static class TaskListEntityBuilder {
        private UUID id;
        private String title;
        private String description;
        private List<TaskEntity> tasks;
        private LocalDateTime created;
        private LocalDateTime updated;

        TaskListEntityBuilder() {
        }

        public TaskListEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public TaskListEntityBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TaskListEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TaskListEntityBuilder tasks(List<TaskEntity> tasks) {
            this.tasks = tasks;
            return this;
        }

        public TaskListEntityBuilder created(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public TaskListEntityBuilder updated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public TaskListEntity build() {
            return new TaskListEntity(this.id, this.title, this.description, this.tasks, this.created, this.updated);
        }

        public String toString() {
            return "TaskListEntity.TaskListEntityBuilder(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", tasks=" + this.tasks + ", created=" + this.created + ", updated=" + this.updated + ")";
        }
    }
}

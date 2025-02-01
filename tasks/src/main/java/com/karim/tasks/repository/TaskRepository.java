package com.karim.tasks.repository;

import com.karim.tasks.domain.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findByTaskListId(UUID taskListId);
    Optional<TaskEntity> findByTaskListIdAndId(UUID taskListId,UUID id);
    void deleteByTaskListIdAndId(UUID taskListId,UUID id);
}

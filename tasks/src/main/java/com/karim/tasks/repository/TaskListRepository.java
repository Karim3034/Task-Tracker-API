package com.karim.tasks.repository;

import com.karim.tasks.domain.entities.TaskListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskListEntity, UUID> {
}

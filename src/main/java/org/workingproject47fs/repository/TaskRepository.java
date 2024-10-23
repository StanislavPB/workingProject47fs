package org.workingproject47fs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.Task;
import org.workingproject47fs.entity.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTaskName(String taskName);

    List<Task> findByManager(Manager manager);

    List<Task> findByStatus(TaskStatus status);

}

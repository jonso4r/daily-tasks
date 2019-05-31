package dev.jonatansoares.daily.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jonatansoares.daily.tasks.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

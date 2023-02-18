package shop.tukoreamyway.back.domain.task.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.task.command.application.TaskRepository;
import shop.tukoreamyway.back.domain.task.entity.Task;

public interface JpaTaskRepository extends TaskRepository, JpaRepository<Task, Long> {}

package shop.tukoreamyway.back.domain.task.command.application;

import shop.tukoreamyway.back.domain.task.entity.Task;

public interface TaskRepository {
    Task save(Task task);
}

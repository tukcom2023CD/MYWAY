package shop.tukoreamyway.back.domain.task.query.application;

import shop.tukoreamyway.back.domain.task.entity.Task;

import java.util.Optional;

public interface TaskQueryRepository {
    Optional<Task> findById(Long id);
}

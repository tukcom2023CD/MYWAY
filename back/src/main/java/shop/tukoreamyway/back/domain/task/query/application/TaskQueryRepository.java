package shop.tukoreamyway.back.domain.task.query.application;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.task.entity.Task;

import java.util.Optional;

public interface TaskQueryRepository extends JpaRepository<Task, Long>, TaskQueryRepositoryCustom {
    Optional<Task> findById(Long id);
}

package shop.tukoreamyway.back.task;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.task.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

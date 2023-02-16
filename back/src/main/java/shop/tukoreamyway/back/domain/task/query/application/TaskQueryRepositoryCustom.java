package shop.tukoreamyway.back.domain.task.query.application;

import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.entity.Task;

import java.util.List;

public interface TaskQueryRepositoryCustom {
    List<Task> findAllByCondition(TaskSearchCondition condition);
}

package shop.tukoreamyway.back.domain.task.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.global.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@QueryService
@RequiredArgsConstructor
public class TaskQueryService {
    private final TaskQueryRepository taskQueryRepository;
    private final TaskMapper taskMapper;
    public List<TaskSummary> findAllByCondition(TaskSearchCondition condition) {
        return taskQueryRepository.findAllByCondition(condition).stream().map(taskMapper::toSummary).toList();
    }
    public TaskResponse findById(Long id) {
        return taskMapper.toResponse(getEntity(id));
    }
    public Task getEntity(Long id) {
        return taskQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

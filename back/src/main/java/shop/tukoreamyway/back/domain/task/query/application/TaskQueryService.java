package shop.tukoreamyway.back.domain.task.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffLoader;
import shop.tukoreamyway.back.domain.task.dto.MyTaskCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@QueryService
@RequiredArgsConstructor
public class TaskQueryService implements EntityLoader<Task, Long> {
    private final TaskQueryRepository taskQueryRepository;
    private final TaskMapper taskMapper;
    private final StaffLoader staffLoader;

    public List<TaskSummary> findAllByCondition(final TaskSearchCondition condition) {
        return taskQueryRepository.findAllByCondition(condition).stream()
                .map(taskMapper::toSummary)
                .toList();
    }

    public TaskResponse findById(final Long id) {
        return taskMapper.toResponse(getEntity(id));
    }

    public Task getEntity(final Long id) {
        return taskQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<TaskSummary> findAllMyTask(final MyTaskCondition condition) {
        final Staff activeStaff = staffLoader.getActiveStaff(condition.getTeamId());
        return findAllByCondition(condition.toSearchCondition(activeStaff.getId()));
    }
}

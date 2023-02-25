package shop.tukoreamyway.back.domain.task.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.task.dto.MyTaskCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.global.service.QueryService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class TaskQueryService implements EntityQueryService<Task, Long> {
    private final TaskQueryRepository taskQueryRepository;
    private final TaskMapper taskMapper;
    private final StaffQueryService staffQueryService;

    public List<TaskSummary> findAllByCondition(TaskSearchCondition condition) {
        return taskQueryRepository.findAllByCondition(condition).stream()
                .map(taskMapper::toSummary)
                .toList();
    }

    public TaskResponse findById(Long id) {
        return taskMapper.toResponse(getEntity(id));
    }

    public Task getEntity(Long id) {
        return taskQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<TaskSummary> findAllMyTask(MyTaskCondition condition) {
        Staff activeStaff = staffQueryService.getActiveStaff(condition.getTeamId());
        return findAllByCondition(condition.toSearchCondition(activeStaff.getId()));
    }
}

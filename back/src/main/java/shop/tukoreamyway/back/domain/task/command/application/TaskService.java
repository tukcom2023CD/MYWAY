package shop.tukoreamyway.back.domain.task.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.sprint.query.application.SprintQueryService;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.global.CommandService;
import shop.tukoreamyway.back.global.IdResponse;

import java.util.Optional;

@CommandService
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final StaffQueryService staffQueryService;
    private final SprintQueryService sprintQueryService;
    private final TaskMapper taskMapper;

    public IdResponse<Long> create(TaskRequest dto) {
        Staff player = Optional.ofNullable(dto.getPlayerId()).map(staffQueryService::getEntity).orElse(null);
        Staff reviewer = Optional.ofNullable(dto.getReviewerId()).map(staffQueryService::getEntity).orElse(null);
        Sprint sprint = sprintQueryService.getEntity(dto.getSprintId());
        Task task = taskRepository.save(taskMapper.toEntity(dto, sprint, player, reviewer));
        return new IdResponse<>(task.getId());
    }
}

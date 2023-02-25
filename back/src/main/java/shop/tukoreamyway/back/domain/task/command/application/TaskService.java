package shop.tukoreamyway.back.domain.task.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.task.dto.AllocateTaskRequest;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.dto.UpdateTaskStatusRequest;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityQueryService;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskQueryRepository taskQueryRepository;
    private final StaffQueryService staffQueryService;
    private final EntityQueryService<Sprint, Long> sprintEntityQueryService;
    private final TaskMapper taskMapper;

    public IdResponse<Long> create(TaskRequest dto) {
        Staff player =
                Optional.ofNullable(dto.getPlayerId())
                        .map(staffQueryService::getEntity)
                        .orElse(null);
        Staff reviewer =
                Optional.ofNullable(dto.getReviewerId())
                        .map(staffQueryService::getEntity)
                        .orElse(null);
        Sprint sprint = sprintEntityQueryService.getEntity(dto.getSprintId());
        Task task = taskRepository.save(taskMapper.toEntity(dto, sprint, player, reviewer));
        return new IdResponse<>(task.getId());
    }

    public void allocate(Long id, AllocateTaskRequest dto) {
        Staff player = staffQueryService.getEntity(dto.getStaffId());
        getEntity(id).changePlayer(player);
    }

    public void bring(Long id) {
        Long teamId = getEntity(id).getSprint().getTeamId();
        getEntity(id).changePlayer(staffQueryService.getActiveStaff(teamId));
    }

    private Task getEntity(Long id) {
        return taskQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void updateStatus(Long id, UpdateTaskStatusRequest dto) {
        getEntity(id).updateStatus(dto.getStatus());
        if (dto.getStatus().equals(TaskStatus.COMPLETE)) {
            // Ability 부여 TODO
        }
    }
}

package shop.tukoreamyway.back.domain.task.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffLoader;
import shop.tukoreamyway.back.domain.task.dto.AllocateTaskRequest;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.dto.UpdateTaskStatusRequest;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;
import shop.tukoreamyway.back.domain.task.mapper.TaskMapper;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskQueryRepository taskQueryRepository;
    private final EntityLoader<Staff, Long> staffEntityLoader;
    private final StaffLoader staffLoader;
    private final EntityLoader<Sprint, Long> sprintLoader;
    private final TaskMapper taskMapper;

    public IdResponse<Long> create(final TaskRequest dto) {
        final Staff player =
                Optional.ofNullable(dto.getPlayerId())
                        .map(staffEntityLoader::getEntity)
                        .orElse(null);
        final Staff reviewer =
                Optional.ofNullable(dto.getReviewerId())
                        .map(staffEntityLoader::getEntity)
                        .orElse(null);
        final Sprint sprint = sprintLoader.getEntity(dto.getSprintId());
        final Task task = taskRepository.save(taskMapper.toEntity(dto, sprint, player, reviewer));
        return new IdResponse<>(task.getId());
    }

    public void allocate(Long id, AllocateTaskRequest dto) {
        Staff player = staffEntityLoader.getEntity(dto.getStaffId());
        getEntity(id).changePlayer(player);
    }

    public void bring(Long id) {
        Long teamId = getEntity(id).getSprint().getTeamId();
        getEntity(id).changePlayer(staffLoader.getActiveStaff(teamId));
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

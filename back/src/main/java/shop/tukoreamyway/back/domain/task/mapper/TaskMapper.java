package shop.tukoreamyway.back.domain.task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.entity.Task;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    Task toEntity(TaskRequest dto, Sprint sprint, Staff player, Staff reviewer);

    TaskResponse toResponse(Task entity);

    TaskSummary toSummary(Task entity);
}

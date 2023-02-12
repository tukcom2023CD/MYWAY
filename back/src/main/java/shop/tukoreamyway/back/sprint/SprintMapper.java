package shop.tukoreamyway.back.sprint;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.project.Project;
import shop.tukoreamyway.back.sprint.dto.SprintRequest;
import shop.tukoreamyway.back.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.sprint.dto.SprintSummary;
import shop.tukoreamyway.back.staff.StaffSummary;
import shop.tukoreamyway.back.staff.domain.Staff;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SprintMapper {

    Sprint toEntity(SprintRequest dto);
    SprintSummary toSummary(Sprint entity);
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "leader", source = "leader")
    SprintResponse toResponse(Sprint entity, Project project, Staff leader);

    @Mapping(target = "name" , source = "member.name")
    StaffSummary toStaffSummary(Staff entity);
}

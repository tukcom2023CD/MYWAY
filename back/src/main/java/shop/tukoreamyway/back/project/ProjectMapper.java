package shop.tukoreamyway.back.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.project.dto.ProjectRequest;
import shop.tukoreamyway.back.project.dto.ProjectResponse;
import shop.tukoreamyway.back.project.dto.ProjectSummary;
import shop.tukoreamyway.back.staff.StaffSummary;
import shop.tukoreamyway.back.staff.domain.Staff;
import shop.tukoreamyway.back.team.domain.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectRequest dto);
    ProjectSummary toSummary(Project entity);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "name", source = "entity.name")
    @Mapping(target = "manager", source = "manager")
    ProjectResponse toResponse(Project entity, Team team, Staff manager);

    @Mapping(target = "name" , source = "member.name")
    StaffSummary toStaffSummary(Staff entity);
}

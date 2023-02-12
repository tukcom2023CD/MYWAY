package shop.tukoreamyway.back.project;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.project.dto.ProjectRequest;
import shop.tukoreamyway.back.project.dto.ProjectResponse;
import shop.tukoreamyway.back.project.dto.ProjectSummary;
import shop.tukoreamyway.back.staff.domain.Staff;
import shop.tukoreamyway.back.team.domain.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectRequest dto);
    ProjectSummary toSummary(Project entity);

    ProjectResponse toResponse(Project project, Team team, Staff manager);
}

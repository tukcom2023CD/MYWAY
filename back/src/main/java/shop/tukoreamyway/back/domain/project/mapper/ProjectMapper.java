package shop.tukoreamyway.back.domain.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "manager", source = "manager")
    Project toEntity(ProjectRequest dto, Team team, Staff manager) ;

    @Mapping(target = "manager", source = "manager")
    ProjectResponse toResponse(Project entity);
}

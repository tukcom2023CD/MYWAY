package shop.tukoreamyway.back.domain.project.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.project.mapper.ProjectMapper;
import shop.tukoreamyway.back.domain.sprint.command.application.SprintService;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryService;
import shop.tukoreamyway.back.global.CommandService;

@CommandService
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final SprintService sprintService;
    private final StaffQueryService staffQueryService;
    private final TeamQueryService teamQueryService;
    private final ProjectMapper projectMapper;

    public ProjectResponse create(ProjectRequest dto) {
        Staff manager = staffQueryService.getEntity(dto.getManagerId());
        Team team = teamQueryService.getEntity(dto.getTeamId());
        Project project = projectRepository.save(projectMapper.toEntity(dto, team, manager));
        sprintService.createInitial(project);
        return projectMapper.toResponse(project);
    }
}

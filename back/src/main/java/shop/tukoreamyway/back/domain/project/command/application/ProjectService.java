package shop.tukoreamyway.back.domain.project.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.project.mapper.ProjectMapper;
import shop.tukoreamyway.back.domain.sprint.command.application.SprintService;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

@CommandService
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final SprintService sprintService;
    private final EntityLoader<Staff, Long> staffLoader;
    private final EntityLoader<Team, Long> teamLoader;
    private final ProjectMapper projectMapper;

    public ProjectResponse create(final ProjectRequest dto) {
        final Staff manager = staffLoader.getEntity(dto.getManagerId());
        final Team team = teamLoader.getEntity(dto.getTeamId());
        final Project project = projectRepository.save(projectMapper.toEntity(dto, team, manager));
        sprintService.createInitial(project);
        return projectMapper.toResponse(project);
    }
}

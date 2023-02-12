package shop.tukoreamyway.back.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.project.dto.ProjectRequest;
import shop.tukoreamyway.back.project.dto.ProjectResponse;
import shop.tukoreamyway.back.project.dto.ProjectSummary;
import shop.tukoreamyway.back.staff.StaffService;
import shop.tukoreamyway.back.staff.domain.Staff;
import shop.tukoreamyway.back.team.TeamService;
import shop.tukoreamyway.back.team.domain.Team;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final StaffService staffService;
    private final ProjectMapper projectMapper;
    private final TeamService teamService;

    @Transactional
    public ProjectSummary create(ProjectRequest dto) {
        Project project = projectRepository.save(projectMapper.toEntity(dto));
        return projectMapper.toSummary(project);
    }

    public Project getEntity(Long id) {
        return projectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ProjectResponse findById(Long id) {
        Project project = getEntity(id);
        Team team = teamService.getEntity(project.getTeamId());
        Staff manager = staffService.getEntity(project.getManagerId());

        return projectMapper.toResponse(project, team, manager);
    }

    public List<ProjectSummary> findAllByTeamId(Long teamId) {
        return projectRepository.findAllByTeamId(teamId).stream().map(projectMapper::toSummary).collect(Collectors.toList());
    }
}

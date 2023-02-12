package shop.tukoreamyway.back.sprint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.project.Project;
import shop.tukoreamyway.back.project.ProjectService;
import shop.tukoreamyway.back.sprint.dto.SprintRequest;
import shop.tukoreamyway.back.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.sprint.dto.SprintSummary;
import shop.tukoreamyway.back.staff.StaffService;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;
    private final SprintMapper sprintMapper;
    private final StaffService staffService;
    private final ProjectService projectService;

    public SprintSummary create(SprintRequest dto) {
        Sprint sprint = sprintRepository.save(sprintMapper.toEntity(dto));
        return sprintMapper.toSummary(sprint);
    }

    public SprintResponse findById(Long id) {
        Sprint sprint = getEntity(id);
        Staff staff = staffService.getEntity(sprint.getLeaderId());
        Project project = projectService.getEntity(sprint.getProjectId());
        return sprintMapper.toResponse(sprint, project, staff);
    }

    private Sprint getEntity(Long id) {
        return sprintRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<SprintSummary> findAllByProjectId(Long projectId) {
        return sprintRepository.findAllByProjectId(projectId).stream().map(sprintMapper::toSummary).collect(Collectors.toList());
    }
}

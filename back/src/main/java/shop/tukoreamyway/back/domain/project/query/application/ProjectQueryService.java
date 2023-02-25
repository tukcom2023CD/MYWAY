package shop.tukoreamyway.back.domain.project.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.mapper.ProjectMapper;
import shop.tukoreamyway.back.global.service.QueryService;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class ProjectQueryService {
    private final ProjectQueryRepository projectQueryRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectResponse> findAllByTeamId(Long teamId) {
        return projectQueryRepository.findAllByTeamId(teamId).stream()
                .map(projectMapper::toResponse)
                .toList();
    }
}

package shop.tukoreamyway.back.domain.sprint.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.sprint.mapper.SprintMapper;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@QueryService
@RequiredArgsConstructor
public class SprintQueryService implements EntityLoader<Sprint, Long> {
    private final SprintQueryRepository sprintQueryRepository;
    private final SprintMapper sprintMapper;

    public Sprint getEntity(final Long sprintId) {
        return sprintQueryRepository.findById(sprintId).orElseThrow(EntityNotFoundException::new);
    }

    public List<SprintResponse> findAllByProjectId(final Long projectId) {
        return sprintQueryRepository.findAllByProjectId(projectId).stream().map(sprintMapper::toResponse).toList();
    }
}

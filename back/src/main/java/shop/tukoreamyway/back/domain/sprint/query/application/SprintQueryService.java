package shop.tukoreamyway.back.domain.sprint.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class SprintQueryService implements EntityQueryService<Sprint, Long> {
    private final SprintQueryRepository sprintQueryRepository;

    public Sprint getEntity(Long sprintId) {
        return sprintQueryRepository.findById(sprintId).orElseThrow(EntityNotFoundException::new);
    }
}

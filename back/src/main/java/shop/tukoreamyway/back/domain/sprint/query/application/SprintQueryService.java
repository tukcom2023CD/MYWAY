package shop.tukoreamyway.back.domain.sprint.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class SprintQueryService implements EntityLoader<Sprint, Long> {
    private final SprintQueryRepository sprintQueryRepository;

    public Sprint getEntity(final Long sprintId) {
        return sprintQueryRepository.findById(sprintId).orElseThrow(EntityNotFoundException::new);
    }
}

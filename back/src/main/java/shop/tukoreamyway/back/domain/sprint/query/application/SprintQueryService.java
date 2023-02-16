package shop.tukoreamyway.back.domain.sprint.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.global.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class SprintQueryService {
    private final SprintQueryRepository sprintQueryRepository;
    public Sprint getEntity(Long sprintId) {
        return sprintQueryRepository.findById(sprintId).orElseThrow(EntityNotFoundException::new);
    }
}

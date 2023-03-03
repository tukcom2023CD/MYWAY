package shop.tukoreamyway.back.domain.team.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class TeamQueryService implements EntityLoader<Team, Long> {
    private final TeamQueryRepository teamQueryRepository;

    public Team getEntity(final Long id) {
        return teamQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

package shop.tukoreamyway.back.domain.team.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class TeamQueryService {
    private final TeamQueryRepository teamQueryRepository;

    public Team getEntity(Long id) {
        return teamQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

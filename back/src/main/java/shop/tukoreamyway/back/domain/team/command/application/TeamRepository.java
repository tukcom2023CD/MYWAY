package shop.tukoreamyway.back.domain.team.command.application;

import shop.tukoreamyway.back.domain.team.entity.Team;

public interface TeamRepository {
    Team save(Team team);
}

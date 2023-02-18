package shop.tukoreamyway.back.domain.team.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.team.command.application.TeamRepository;
import shop.tukoreamyway.back.domain.team.entity.Team;

public interface JpaTeamRepository extends TeamRepository, JpaRepository<Team, Long> {}

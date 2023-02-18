package shop.tukoreamyway.back.domain.project.query.application;

import shop.tukoreamyway.back.domain.project.entity.Project;

import java.util.List;

public interface ProjectQueryRepository {
    List<Project> findAllByTeamId(Long teamId);
}

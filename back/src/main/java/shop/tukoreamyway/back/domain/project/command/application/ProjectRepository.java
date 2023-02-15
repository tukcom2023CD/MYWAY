package shop.tukoreamyway.back.domain.project.command.application;

import shop.tukoreamyway.back.domain.project.entity.Project;

public interface ProjectRepository {
    Project save(Project project);
}

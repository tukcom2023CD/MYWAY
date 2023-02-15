package shop.tukoreamyway.back.domain.sprint.command.application;

import shop.tukoreamyway.back.domain.sprint.entity.Sprint;

public interface SprintRepository {
    Sprint save(Sprint sprint);
}

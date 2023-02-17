package shop.tukoreamyway.back.support.fixture.task;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;
import shop.tukoreamyway.back.support.fixture.sprint.SprintResponseFixture;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaskSummaryFixture {
    SAMPLE1(1L, "요약1",  TaskStatus.PROGRESS, AbilityCategory.DEVELOPMENT, SprintResponseFixture.SAMPLE1.toDto(), StaffSummaryFixture.CAPTAIN.toDto(), null),
    SAMPLE2(2L, "요약2",  TaskStatus.PROGRESS, AbilityCategory.DEVELOPMENT, SprintResponseFixture.SAMPLE1.toDto(), StaffSummaryFixture.CAPTAIN.toDto(), null),
    SAMPLE3(3L, "요약3",  TaskStatus.PROGRESS, AbilityCategory.DEVELOPMENT, SprintResponseFixture.SAMPLE1.toDto(), StaffSummaryFixture.CAPTAIN.toDto(), null)
    ;
    private final Long id;
    private final String summary;
    private final TaskStatus status;
    private final AbilityCategory category;
    private final SprintResponse sprint;
    private final StaffSummary player;
    private final StaffSummary reviewer;

    public TaskSummary toDto() {
        return TaskSummary.builder()
              .id(id)
              .summary(summary)
              .status(status.getName())
              .category(category.getName())
              .sprint(sprint)
              .player(player)
              .reviewer(reviewer)
              .build();
    }
}

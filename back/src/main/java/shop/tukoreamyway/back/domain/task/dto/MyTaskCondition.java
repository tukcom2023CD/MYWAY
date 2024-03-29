package shop.tukoreamyway.back.domain.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyTaskCondition {
    private AbilityCategory category;
    private TaskStatus status;
    private Long sprintId;
    private Long teamId;

    public TaskSearchCondition toSearchCondition(Long playerId) {
        return new TaskSearchCondition(status, category, sprintId, playerId);
    }
}

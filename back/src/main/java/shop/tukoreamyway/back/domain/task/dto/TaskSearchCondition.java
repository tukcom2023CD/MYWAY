package shop.tukoreamyway.back.domain.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskSearchCondition {
    private TaskStatus status;
    private AbilityCategory category;
    private Long sprintId;
    private Long playerId;
}

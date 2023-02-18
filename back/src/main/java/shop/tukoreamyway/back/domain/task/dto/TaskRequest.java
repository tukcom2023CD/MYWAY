package shop.tukoreamyway.back.domain.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    @NotBlank private String summary;
    private String description;
    @NotNull private Integer contributePoint;
    @NotNull private AbilityCategory category;
    @NotNull private Long sprintId;
    private Long playerId;
    private Long reviewerId;
}

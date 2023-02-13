package shop.tukoreamyway.back.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    private String summary;
    private String description;
    private Long playerId;
    private Long reviewerId;
}

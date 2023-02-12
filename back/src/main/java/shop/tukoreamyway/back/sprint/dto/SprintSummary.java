package shop.tukoreamyway.back.sprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SprintSummary {
    private Long id;
    private Long projectId;
    private Long round;
    private Long leaderId;
}

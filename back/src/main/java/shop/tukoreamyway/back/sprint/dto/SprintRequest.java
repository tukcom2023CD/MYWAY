package shop.tukoreamyway.back.sprint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SprintRequest {
    private Long projectId;
    private Integer round;
    private Long leaderId;
}

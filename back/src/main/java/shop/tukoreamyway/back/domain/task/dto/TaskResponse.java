package shop.tukoreamyway.back.domain.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

@Getter
@Builder
@AllArgsConstructor
public class TaskResponse {
    private Long id;
    private String summary;
    private String description;
    private String status;
    private Integer contributePoint;
    private String category;
    private SprintResponse sprint;
    private StaffSummary player;
    private StaffSummary reviewer;
}

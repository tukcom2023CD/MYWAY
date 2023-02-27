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
    private final Long id;
    private final String summary;
    private final String description;
    private final String status;
    private final Integer contributePoint;
    private final String category;
    private final SprintResponse sprint;
    private final StaffSummary player;
    private final StaffSummary reviewer;
}

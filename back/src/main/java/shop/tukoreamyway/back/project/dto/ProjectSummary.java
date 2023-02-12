package shop.tukoreamyway.back.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ProjectSummary {
    private Long id;
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Long teamId;
    private Integer sprintDays = 7;
    private Long managerId;
}

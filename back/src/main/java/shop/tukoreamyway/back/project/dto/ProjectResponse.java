package shop.tukoreamyway.back.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.staff.StaffSummary;
import shop.tukoreamyway.back.team.dto.TeamSummary;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private TeamSummary team;
    private Integer sprintDays = 7;
    private StaffSummary manager;
}

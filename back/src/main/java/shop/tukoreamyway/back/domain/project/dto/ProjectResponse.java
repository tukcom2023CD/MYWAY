package shop.tukoreamyway.back.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ProjectResponse {
    private final Long id;
    private final String name;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final TeamSummary team;
    private final Integer sprintDays;
    private final StaffSummary manager;
}

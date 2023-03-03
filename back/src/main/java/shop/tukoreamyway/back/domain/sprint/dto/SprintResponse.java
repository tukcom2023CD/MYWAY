package shop.tukoreamyway.back.domain.sprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class SprintResponse {
    private final Long id;
    private final ProjectResponse project;
    private final Integer round;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final StaffSummary leader;
}

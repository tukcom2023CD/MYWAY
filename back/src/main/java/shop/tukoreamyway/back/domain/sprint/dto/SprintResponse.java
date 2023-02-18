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
    private Long id;
    private ProjectResponse project;
    private Integer round;
    private LocalDate startDate;
    private LocalDate endDate;
    private StaffSummary leader;
}

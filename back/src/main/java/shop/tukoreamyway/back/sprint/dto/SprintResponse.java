package shop.tukoreamyway.back.sprint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.project.dto.ProjectSummary;
import shop.tukoreamyway.back.staff.StaffSummary;

@Getter
@Builder
@AllArgsConstructor
public class SprintResponse {
    private Long id;
    private ProjectSummary project;
    private Integer round;
    private StaffSummary leader;
}

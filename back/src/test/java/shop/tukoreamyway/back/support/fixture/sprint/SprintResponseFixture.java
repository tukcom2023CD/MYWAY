package shop.tukoreamyway.back.support.fixture.sprint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.fixture.project.ProjectResponseFixture;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SprintResponseFixture {
    SAMPLE1(
            1L,
            ProjectResponseFixture.ENDGAME.toDto(),
            3,
            LocalDate.now(),
            LocalDate.now().plusDays(3),
            StaffSummaryFixture.IRON_MAN.toDto());
    private final Long id;
    private final ProjectResponse project;
    private final Integer round;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final StaffSummary leader;

    public SprintResponse toDto() {
        return new SprintResponse(id, project, round, startDate, endDate, leader);
    }
}

package shop.tukoreamyway.back.support.fixture.project;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;
import shop.tukoreamyway.back.support.fixture.team.TeamSummaryFixture;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProjectResponseFixture {
    ENDGAME(1L, "엔드게임", LocalDateTime.now(), LocalDateTime.now().plusMonths(5), TeamSummaryFixture.AVENGERS.toDto(), 5, StaffSummaryFixture.CAPTAIN.toDto());
    private final Long id;
    private final String name;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final TeamSummary team;
    private final Integer sprintDays;
    private final StaffSummary manager;

    public ProjectResponse toDto() {
        return new ProjectResponse(id, name, startAt, endAt, team, sprintDays, manager);
    }
}

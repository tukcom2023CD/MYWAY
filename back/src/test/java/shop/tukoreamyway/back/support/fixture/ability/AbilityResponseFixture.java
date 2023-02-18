package shop.tukoreamyway.back.support.fixture.ability;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import shop.tukoreamyway.back.domain.ability.dto.AbilityResponse;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AbilityResponseFixture {
    SAMPLE1(
            1L,
            AbilityCategory.DEVELOPMENT,
            StaffSummaryFixture.THOR.toDto(),
            10L,
            LocalDateTime.now(),
            GrantLocation.DO_TASK,
            null),
    SAMPLE2(
            2L,
            AbilityCategory.DEVELOPMENT,
            StaffSummaryFixture.THOR.toDto(),
            14L,
            LocalDateTime.now(),
            GrantLocation.PROJECT_MANAGER_DISCRETION,
            StaffSummaryFixture.CAPTAIN.toDto()),
    SAMPLE3(
            3L,
            AbilityCategory.DEVELOPMENT,
            StaffSummaryFixture.THOR.toDto(),
            16L,
            LocalDateTime.now(),
            GrantLocation.DO_TASK,
            null),
    ;
    private final Long id;
    private final AbilityCategory category;
    private final StaffSummary receiver;
    private final Long point;
    private final LocalDateTime grantedAt;
    private final GrantLocation grantLocation;
    private final StaffSummary grantor;

    public AbilityResponse toDto() {
        return new AbilityResponse(
                id, category.getName(), receiver, point, grantedAt, grantLocation.name(), grantor);
    }
}

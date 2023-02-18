package shop.tukoreamyway.back.support.fixture.staff;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.domain.staff.entity.Rank;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum StaffSummaryFixture {
    IRON_MAN(1L, "아이언맨", Rank.ASSISTANT),
    CAPTAIN(2L, "캡틴 아메리카", Rank.MANAGER),
    THOR(3L, "토르", Rank.ASSISTANT);

    private final Long id;
    private final String nickname;
    private final Rank rank;

    public StaffSummary toDto() {
        return new StaffSummary(id, nickname, rank.getName());
    }
}

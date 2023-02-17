package shop.tukoreamyway.back.support.fixture.team;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TeamSummaryFixture {
    AVENGERS(1L, "어벤져스", IndustryGroup.HEALTH_WELFARE),
    YG(2L, "YG엔터테이먼트", IndustryGroup.ART_SPORTS);

    private final Long id;
    private final String name;
    private final IndustryGroup industryGroup;

    public TeamSummary toDto() {
        return TeamSummary.builder()
              .id(id)
              .name(name)
              .industryGroup(industryGroup.getName())
              .build();
    }
}

package shop.tukoreamyway.back.support.fixture;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.team.domain.IndustryGroup;
import shop.tukoreamyway.back.team.domain.Team;

public enum TeamFixture {
    T1("삼양", IndustryGroup.IT),
    T2("애플", IndustryGroup.IT);

    private final String name;
    private final IndustryGroup industryGroup;

    TeamFixture(String name, IndustryGroup industryGroup) {
        this.name = name;
        this.industryGroup = industryGroup;
    }

    public Team toEntity(Member member) {
        return new Team(name, member, industryGroup);
    }
}

package shop.tukoreamyway.back.team.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.global.Basetime;
import shop.tukoreamyway.back.member.domain.Member;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false)
    private Member leader;
    private IndustryGroup industryGroup;
    private Basetime basetime;

    @Builder
    public Team(String name, Member leader, IndustryGroup industryGroup) {
        this.name = name;
        this.leader = leader;
        this.industryGroup = industryGroup;
    }
}

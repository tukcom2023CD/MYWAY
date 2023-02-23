package shop.tukoreamyway.back.domain.team.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.global.basetime.AuditListener;
import shop.tukoreamyway.back.global.basetime.Auditable;
import shop.tukoreamyway.back.global.basetime.BaseTime;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditListener.class)
public class Team implements Auditable {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false)
    private Member leader;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IndustryGroup industryGroup;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    public Team(String name, Member leader, IndustryGroup industryGroup) {
        this.name = name;
        this.leader = leader;
        this.industryGroup = industryGroup;
    }
}

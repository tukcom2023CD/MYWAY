package shop.tukoreamyway.back.domain.staff.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.team.entity.Team;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean isAcceptMember = false;
    @Column(nullable = false)
    private Boolean isAcceptTeam = false;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    public Staff(Team team, Member member, String name, Rank rank) {
        this.team = team;
        this.member = member;
        this.name = name;
        this.rank = rank;
    }

    public void acceptMember() {
        isAcceptMember = true;
    }
    public void acceptTeam() {
        isAcceptTeam = true;
    }

    public boolean isHost(UUID memberId) {
        return member.getId().equals(memberId);
    }
}

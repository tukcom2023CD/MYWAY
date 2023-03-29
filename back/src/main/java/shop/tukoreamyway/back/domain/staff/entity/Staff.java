package shop.tukoreamyway.back.domain.staff.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.team.entity.Team;

import java.util.UUID;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff {
    @Id @GeneratedValue private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private Boolean isAcceptMember = false;

    @Column(nullable = false)
    private Boolean isAcceptTeam = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rank rank = Rank.CLERK;

    public Staff(Team team, Member member) {
        this.team = team;
        this.member = member;
        this.nickname = member.getName();
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeRank(Rank rank) {
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

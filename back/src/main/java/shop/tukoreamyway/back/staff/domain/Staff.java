package shop.tukoreamyway.back.staff.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.domain.Team;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Staff {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    private Boolean isAccept = false;

    @Enumerated(EnumType.STRING)
    private Rank rank;
    public void accept() {
        isAccept = true;
    }

    public Staff(Team team, Member member) {
        this.team = team;
        this.member = member;
    }

    public boolean isHost(UUID memberId) {
        return member.getId().equals(memberId);
    }
}

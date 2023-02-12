package shop.tukoreamyway.back.staff;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.domain.Team;

import javax.persistence.*;

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

    public void accept() {
        isAccept = true;
    }

    public Staff(Team team, Member member) {
        this.team = team;
        this.member = member;
    }
}

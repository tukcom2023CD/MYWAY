package shop.tukoreamyway.back.organization.domain;

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
public class Organization {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Member owner;
    private IndustryGroup industryGroup;
    private Basetime basetime;

    @Builder
    public Organization(String name, Member owner, IndustryGroup industryGroup) {
        this.name = name;
        this.owner = owner;
        this.industryGroup = industryGroup;
    }
}

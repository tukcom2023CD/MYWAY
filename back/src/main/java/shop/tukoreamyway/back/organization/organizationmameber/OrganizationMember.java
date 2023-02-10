package shop.tukoreamyway.back.organization.organizationmameber;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.organization.domain.Organization;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class OrganizationMember {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    private Boolean isAccept = false;

    public void accept() {
        isAccept = true;
    }

    public OrganizationMember(Organization organization, Member member) {
        this.organization = organization;
        this.member = member;
    }
}

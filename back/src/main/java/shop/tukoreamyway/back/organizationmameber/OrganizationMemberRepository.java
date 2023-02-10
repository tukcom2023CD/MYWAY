package shop.tukoreamyway.back.organizationmameber;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.domain.Member;

import java.util.List;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMember, Long> {
    List<OrganizationMember> findAllByOrganizationId(Long id);
    List<OrganizationMember> findAllByMember(Member member);
}

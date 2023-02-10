package shop.tukoreamyway.back.organization.organizationmameber;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationMemberRepository extends JpaRepository<OrganizationMember, Long> {
    List<OrganizationMember> findAllByOrganizationId(Long id);
    List<OrganizationMember> findAllByMemberId(UUID id);
}

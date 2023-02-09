package shop.tukoreamyway.back.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.organization.domain.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}

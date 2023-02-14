package shop.tukoreamyway.back.domain.staff.query.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;

public interface JpaStaffQueryRepository extends StaffQueryRepository, JpaRepository<Staff, Long> {
}

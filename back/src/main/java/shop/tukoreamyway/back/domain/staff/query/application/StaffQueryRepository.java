package shop.tukoreamyway.back.domain.staff.query.application;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.infra.StaffQueryRepositoryCustom;

import java.util.Optional;

public interface StaffQueryRepository extends JpaRepository<Staff, Long>, StaffQueryRepositoryCustom {
    Optional<Staff> findById(Long id);
}

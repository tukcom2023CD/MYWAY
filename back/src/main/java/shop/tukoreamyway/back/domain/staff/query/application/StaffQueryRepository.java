package shop.tukoreamyway.back.domain.staff.query.application;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.Optional;
import java.util.UUID;

public interface StaffQueryRepository
        extends JpaRepository<Staff, Long>, StaffQueryRepositoryCustom {
    Optional<Staff> findById(Long id);

    Optional<Staff> findByMemberIdAndTeamId(UUID memberId, Long teamId);
}

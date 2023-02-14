package shop.tukoreamyway.back.domain.staff.query.application;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.Optional;

public interface StaffQueryRepository {
    Optional<Staff> findById(Long id);
}

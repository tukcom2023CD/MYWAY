package shop.tukoreamyway.back.staff.query.application;

import shop.tukoreamyway.back.staff.domain.Staff;

import java.util.Optional;

public interface StaffQueryRepository {
    Optional<Staff> findById(Long id);
}

package shop.tukoreamyway.back.domain.staff.query.application;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

public interface StaffLoader {
    Staff getActiveStaff(final Long teamId);
}

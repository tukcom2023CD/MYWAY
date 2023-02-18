package shop.tukoreamyway.back.domain.staff.query.application;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.List;
import java.util.UUID;

public interface StaffQueryRepositoryCustom {
    List<Staff> findAllByTeamIdApplyFilter(Long teamId);

    List<Staff> findAllByMemberIdInviteFilter(UUID memberId);

    List<Staff> findAllActiveStaffByTeamId(Long teamId);

    List<Staff> findAllActiveStaffByMemberId(UUID memberId);
}

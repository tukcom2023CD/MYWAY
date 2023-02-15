package shop.tukoreamyway.back.domain.staff.query.infra;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.List;
import java.util.UUID;

public interface StaffQueryRepositoryCustom {
    List<Staff> findAllByTeamIdApplyFilter(Long groupId);

    List<Staff> findAllByMemberIdInviteFilter(UUID memberID);
}

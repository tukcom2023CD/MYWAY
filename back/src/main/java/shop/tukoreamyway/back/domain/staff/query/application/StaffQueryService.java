package shop.tukoreamyway.back.domain.staff.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class StaffQueryService implements StaffLoader, EntityLoader<Staff, Long> {
    private final StaffQueryRepository staffQueryRepository;
    private final AuthService authService;
    private final StaffMapper staffMapper;

    public Staff getEntity(final Long id) {
        return staffQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<StaffResponse> findAllApplyByTeamId(final Long teamId) {
        final List<Staff> staffs = staffQueryRepository.findAllByTeamIdApplyFilter(teamId);
        return mapToList(staffs);
    }

    public List<StaffResponse> findAllInvite() {
        final UUID loginUserId = authService.getLoginUserId();
        final List<Staff> staffs = staffQueryRepository.findAllByMemberIdInviteFilter(loginUserId);
        return mapToList(staffs);
    }

    public List<StaffResponse> findAllTeamStaff(final Long teamId) {
        final List<Staff> staffs = staffQueryRepository.findAllActiveStaffByTeamId(teamId);
        return mapToList(staffs);
    }

    private List<StaffResponse> mapToList(final List<Staff> staffs) {
        return staffs.stream().map(staffMapper::toResponse).toList();
    }

    public Staff getActiveStaff(final Long teamId) {
        final UUID memberId = authService.getLoginUserId();
        return staffQueryRepository
                .findByMemberIdAndTeamId(memberId, teamId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<StaffResponse> findAllMyTeam() {
        final UUID loginUserId = authService.getLoginUserId();
        List<Staff> staffs = staffQueryRepository.findAllActiveStaffByMemberId(loginUserId);
        return mapToList(staffs);
    }
}

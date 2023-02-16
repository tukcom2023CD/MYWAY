package shop.tukoreamyway.back.domain.staff.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;
import shop.tukoreamyway.back.global.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@QueryService
@RequiredArgsConstructor
public class StaffQueryService {
    private final StaffQueryRepository staffQueryRepository;
    private final AuthService authService;
    private final StaffMapper staffMapper;
    public Staff getEntity(Long id) {
        return staffQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<StaffResponse> findAllApplyByTeamId(Long teamId) {
        List<Staff> staffs = staffQueryRepository.findAllByTeamIdApplyFilter(teamId);
        return mapToList(staffs);
    }

    public List<StaffResponse> findAllInvite() {
        UUID loginUserId = authService.getLoginUserId();
        List<Staff> staffs = staffQueryRepository.findAllByMemberIdInviteFilter(loginUserId);
        return mapToList(staffs);
    }

    public List<StaffResponse> findAllTeamStaff(Long teamId) {
        List<Staff> staffs = staffQueryRepository.findAllActiveStaffByTeamId(teamId);
        return mapToList(staffs);
    }

    private List<StaffResponse> mapToList(List<Staff> staffs) {
        return staffs.stream().map(staffMapper::toResponse).toList();
    }

    public Staff getActiveStaff(UUID memberId, Long teamId) {
        return staffQueryRepository.findByMemberIdAndTeamId(memberId, teamId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<StaffResponse> findAllMyTeam() {
        UUID loginUserId = authService.getLoginUserId();
        List<Staff> staffs = staffQueryRepository.findAllActiveStaffByMemberId(loginUserId);
        return mapToList(staffs);
    }
}

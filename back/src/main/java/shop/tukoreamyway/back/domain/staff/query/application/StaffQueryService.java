package shop.tukoreamyway.back.domain.staff.query.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
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
        return staffs.stream().map(staffMapper::toResponse).toList();
    }

    public List<StaffResponse> findAllInvite() {
        UUID loginUserId = authService.getLoginUserId();
        List<Staff> staffs = staffQueryRepository.findAllByMemberIdInviteFilter(loginUserId);
        return staffs.stream().map(staffMapper::toResponse).toList();
    }
}

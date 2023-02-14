package shop.tukoreamyway.back.domain.staff.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.dto.TeamLeaderRequest;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.CommandService;

@CommandService
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final AuthService authService;

    public void createProjectLeaderStaff(final TeamLeaderRequest dto, final Team team) {
        Member loginUser = authService.getLoginUserEntity();
        Staff staff = staffMapper.toEntity(dto, team, loginUser);
        staff.acceptTeam();
        staff.acceptMember();
        staffRepository.save(staff);
    }
}

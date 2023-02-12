package shop.tukoreamyway.back.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.member.AuthService;
import shop.tukoreamyway.back.member.MemberService;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.TeamService;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.staff.dto.InviteTeamRequest;
import shop.tukoreamyway.back.staff.dto.InviteResponse;
import shop.tukoreamyway.back.staff.dto.StaffResponse;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final TeamService teamService;
    private final MemberService memberService;
    private final AuthService authService;

    @Transactional
    public void invite(InviteTeamRequest dto) {
        Team team = teamService.getEntity(dto.getTeamId());
        dto.getMembers().stream()
                .map(memberService::getEntity)
                .map(member -> new Staff(team, member))
                .forEach(staffRepository::save);
    }

    @Transactional
    public void accept(Long id) {
        getEntity(id).accept();
    }

    public Staff getEntity(Long id) {
        return staffRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<InviteResponse> findLoginUserInvites(){
        Member loginUser = authService.getLoginUser();
        return staffRepository.findAllByMember(loginUser).stream().map(staffMapper::toInviteResponse).toList();
    }

    public StaffResponse findByOrganizationId(Long organizationId) {
        Team team = teamService.getEntity(organizationId);
        List<Member> members = staffRepository.findAllByTeamId(organizationId).stream().map(Staff::getMember).toList();
        staffMapper.toResponse(team, members);
        return  staffMapper.toResponse(team, members);
    }
}

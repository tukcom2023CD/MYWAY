package shop.tukoreamyway.back.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.member.service.AuthService;
import shop.tukoreamyway.back.member.service.MemberService;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.team.dto.InviteRequest;
import shop.tukoreamyway.back.team.dto.InviteResponse;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;
import shop.tukoreamyway.back.team.staff.StaffRepository;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final StaffRepository staffRepository;
    private final TeamMapper teamMapper;

    private final MemberService memberService;
    private final AuthService authService;

    @Transactional
    public TeamResponse create(TeamRequest dto) {
        Member loginUser = authService.getLoginUser();
        Team team = teamRepository.save(teamMapper.toEntity(dto, loginUser));
        Staff leader = saveLeader(loginUser, team);
        return teamMapper.toResponse(team, List.of(leader));
    }

    private Staff saveLeader(Member loginUser, Team team) {
        Staff staff = new Staff(team, loginUser);
        staff.accept();
        return staffRepository.save(staff);
    }

    public Team getEntity(Long id) {
        return teamRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void invite(Long teamId, InviteRequest dto) {
        Team team = getEntity(teamId);
        dto.getMembers().stream()
                .map(memberService::getEntity)
                .map(member -> new Staff(team, member))
                .forEach(staffRepository::save);
    }

    @Transactional
    public void accept(Long id) {
        getStaff(id).accept();
    }

    private Staff getStaff(Long id) {
        Member loginUser = authService.getLoginUser();
        return staffRepository.findByTeamIdAndMember(id, loginUser).orElseThrow(EntityNotFoundException::new);
    }

    public List<InviteResponse> findLoginUserInvites(){
        Member loginUser = authService.getLoginUser();
        return staffRepository.findAllByMember(loginUser).stream().map(teamMapper::toInviteResponse).toList();
    }

    public TeamResponse findById(Long id) {
        Team team = getEntity(id);
        List<Staff> staffs = staffRepository.findAllByTeamId(id).stream().toList();
        return  teamMapper.toResponse(team, staffs);
    }
}

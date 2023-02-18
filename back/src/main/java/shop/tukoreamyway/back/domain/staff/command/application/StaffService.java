package shop.tukoreamyway.back.domain.staff.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.member.query.application.MemberQueryService;
import shop.tukoreamyway.back.domain.staff.dto.AcceptApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.AcceptInviteRequest;
import shop.tukoreamyway.back.domain.staff.dto.ApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.InviteRequest;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryService;
import shop.tukoreamyway.back.global.CommandService;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final StaffQueryRepository staffQueryRepository;
    private final StaffMapper staffMapper;
    private final AuthService authService;
    private final TeamQueryService teamQueryService;
    private final MemberQueryService memberQueryService;

    public void createProjectLeaderStaff(final Team team) {
        Member loginUser = authService.getLoginUserEntity();
        Staff staff = staffMapper.toEntity(team, loginUser);
        staff.changeRank(Rank.MANAGER);
        staff.acceptTeam();
        staff.acceptMember();
        staffRepository.save(staff);
    }

    public void invite(InviteRequest dto) {
        Team team = teamQueryService.getEntity(dto.getTeamId());
        dto.getMembers().stream()
                .map(memberQueryService::getEntity)
                .map(member -> new Staff(team, member))
                .forEach(staffRepository::save);
    }

    public void apply(ApplyRequest dto) {
        Member loginUser = authService.getLoginUserEntity();
        Team team = teamQueryService.getEntity(dto.getTeamId());
        staffRepository.save(new Staff(team, loginUser));
    }

    public void acceptInvite(Long id, AcceptInviteRequest dto) {
        Staff staff = getEntity(id);
        Optional.ofNullable(dto.getNickname()).ifPresent(staff::changeNickname);
    }

    public void acceptApply(Long id, AcceptApplyRequest dto) {
        Staff staff = getEntity(id);
        Optional.ofNullable(dto.getRank()).ifPresent(staff::changeRank);
    }

    private Staff getEntity(Long id) {
        return staffQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

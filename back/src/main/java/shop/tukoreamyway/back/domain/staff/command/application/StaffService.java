package shop.tukoreamyway.back.domain.staff.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.dto.AcceptApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.AcceptInviteRequest;
import shop.tukoreamyway.back.domain.staff.dto.ApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.InviteRequest;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.mapper.StaffMapper;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final StaffQueryRepository staffQueryRepository;
    private final StaffMapper staffMapper;
    private final AuthService authService;
    private final EntityLoader<Team, Long> teamLoader;
    private final EntityLoader<Member, UUID> memberLoader;

    public void createProjectLeaderStaff(final Team team) {
        final Member loginUser = authService.getLoginUserEntity();
        final Staff staff = staffMapper.toEntity(team, loginUser);
        staff.changeRank(Rank.MANAGER);
        staff.acceptTeam();
        staff.acceptMember();
        staffRepository.save(staff);
    }

    public void invite(final InviteRequest dto) {
        final Team team = teamLoader.getEntity(dto.getTeamId());
        dto.getMembers().stream()
                .map(memberLoader::getEntity)
                .map(member -> new Staff(team, member))
                .forEach(
                        staff -> {
                            staff.acceptTeam();
                            staffRepository.save(staff);
                        });
    }

    public void apply(final ApplyRequest dto) {
        final Member loginUser = authService.getLoginUserEntity();
        final Team team = teamLoader.getEntity(dto.getTeamId());
        final Staff applyer = new Staff(team, loginUser);
        applyer.acceptMember();
        staffRepository.save(applyer);
    }

    public void acceptInvite(final Long id, final AcceptInviteRequest dto) {
        final Staff staff = getEntity(id);
        staff.acceptMember();
        Optional.ofNullable(dto.getNickname()).ifPresent(staff::changeNickname);
    }

    public void acceptApply(final Long id, final AcceptApplyRequest dto) {
        final Staff staff = getEntity(id);
        staff.acceptTeam();
        Optional.ofNullable(dto.getRank()).ifPresent(staff::changeRank);
    }

    private Staff getEntity(final Long id) {
        return staffQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

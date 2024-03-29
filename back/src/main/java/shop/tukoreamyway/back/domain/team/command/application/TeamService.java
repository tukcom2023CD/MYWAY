package shop.tukoreamyway.back.domain.team.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.staff.command.application.StaffService;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.mapper.TeamMapper;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;

@CommandService
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final StaffService staffService;
    private final AuthService authService;

    public IdResponse<Long> create(final TeamRequest dto) {
        final Member loginUser = authService.getLoginUserEntity();
        final Team team = teamRepository.save(teamMapper.toEntity(dto, loginUser));
        staffService.createProjectLeaderStaff(team);
        return new IdResponse<>(team.getId());
    }
}

package shop.tukoreamyway.back.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.member.AuthService;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    private final AuthService authService;

    public TeamResponse create(TeamRequest dto) {
        Member loginUser = authService.getLoginUser();
        Team team = teamRepository.save(teamMapper.toEntity(dto, loginUser));
        return teamMapper.toResponse(team);
    }

    public Team getEntity(Long id) {
        return teamRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

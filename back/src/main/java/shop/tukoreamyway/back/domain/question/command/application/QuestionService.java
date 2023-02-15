package shop.tukoreamyway.back.domain.question.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.member.query.application.AuthService;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.mapper.QuestionMapper;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryService;
import shop.tukoreamyway.back.global.CommandService;
import shop.tukoreamyway.back.global.IdResponse;

@CommandService
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TeamQueryService teamQueryService;
    private final StaffQueryService staffQueryService;
    private final AuthService authService;
    private final QuestionMapper questionMapper;

    // 1. Question 생성
    public IdResponse<Long> create(QuestionRequest dto) {
        Team team = teamQueryService.getEntity(dto.getTeamId());
        Staff staff = staffQueryService.getActiveStaff(authService.getLoginUserId(), dto.getTeamId());
        Question question = questionRepository.save(questionMapper.toEntity(dto, team, staff));
        return new IdResponse<>(question.getId());
    }

}

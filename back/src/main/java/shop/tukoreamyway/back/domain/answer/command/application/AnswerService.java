package shop.tukoreamyway.back.domain.answer.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.mapper.AnswerMapper;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.global.CommandService;
import shop.tukoreamyway.back.global.IdResponse;

@CommandService
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final StaffQueryService staffQueryService;
    private final QuestionQueryService questionQueryService;
    private final AnswerMapper answerMapper;

    public IdResponse<Long> create(AnswerRequest dto) {
        Question question = questionQueryService.getEntity(dto.getQuestionId());
        Staff writer = staffQueryService.getActiveStaff(question.getTeamId());
        Answer answer = answerRepository.save(answerMapper.toEntity(dto, question, writer));
        return new IdResponse<>(answer.getId());
    }
}

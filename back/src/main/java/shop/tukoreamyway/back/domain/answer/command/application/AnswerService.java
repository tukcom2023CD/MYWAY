package shop.tukoreamyway.back.domain.answer.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.dto.UpdateAnswerRequest;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.mapper.AnswerMapper;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityQueryService;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final StaffQueryService staffQueryService;
    private final EntityQueryService<Question, Long> questionEntityQueryService;
    private final AnswerQueryRepository answerQueryRepository;
    private final AnswerMapper answerMapper;

    public final IdResponse<Long> create(final AnswerRequest dto) {
        final Question question = questionEntityQueryService.getEntity(dto.getQuestionId());
        final Staff writer = staffQueryService.getActiveStaff(question.getTeamId());
        final Answer answer = answerRepository.save(answerMapper.toEntity(dto, question, writer));
        return new IdResponse<>(answer.getId());
    }

    public final void update(final Long id, final UpdateAnswerRequest dto) {
        getEntity(id).update(dto.getContent());
    }

    private Answer getEntity(final Long id) {
        return answerQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

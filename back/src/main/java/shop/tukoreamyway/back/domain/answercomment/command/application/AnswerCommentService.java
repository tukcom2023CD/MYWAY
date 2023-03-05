package shop.tukoreamyway.back.domain.answercomment.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.ability.command.application.AbilityService;
import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.dto.UpdateAnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.mapper.AnswerCommentMapper;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffLoader;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@CommandService
@RequiredArgsConstructor
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final EntityLoader<Answer, Long> answerLoader;
    private final StaffLoader staffLoader;
    private final AnswerCommentQueryRepository answerCommentQueryRepository;
    private final AnswerCommentMapper answerCommentMapper;
    private final AbilityService abilityService;

    public IdResponse<Long> create(final AnswerCommentRequest dto) {
        final Answer answer = answerLoader.getEntity(dto.getAnswerId());
        final Staff writer = staffLoader.getActiveStaff(answer.getQuestion().getTeamId());
        final AnswerComment answerComment =
                answerCommentRepository.save(answerCommentMapper.toEntity(dto, answer, writer));
        abilityService.create(new AbilityRequest(AbilityCategory.COMMUNICATION, writer.getId(), 10L,
                LocalDateTime.now(),
                GrantLocation.WRITE_QUESTION,
                null));
        return new IdResponse<>(answerComment.getId());
    }

    public void update(final Long id, final UpdateAnswerCommentRequest dto) {
        getEntity(id).update(dto.getContent());
    }

    public void deleteById(Long id) {
        answerCommentRepository.deleteById(id);
    }

    private AnswerComment getEntity(final Long id) {
        return answerCommentQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

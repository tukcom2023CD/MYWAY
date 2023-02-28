package shop.tukoreamyway.back.domain.answercomment.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.dto.UpdateAnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.mapper.AnswerCommentMapper;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityQueryService;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final EntityQueryService<Answer, Long> answerEntityQueryService;
    private final StaffQueryService staffQueryService;
    private final AnswerCommentQueryRepository answerCommentQueryRepository;
    private final AnswerCommentMapper answerCommentMapper;

    public IdResponse<Long> create(final AnswerCommentRequest dto) {
        final Answer answer = answerEntityQueryService.getEntity(dto.getAnswerId());
        final Staff writer = staffQueryService.getActiveStaff(answer.getQuestion().getTeamId());
        final AnswerComment answerComment =
                answerCommentRepository.save(answerCommentMapper.toEntity(dto, answer, writer));
        return new IdResponse<>(answerComment.getId());
    }

    public void update(final Long id, final UpdateAnswerCommentRequest dto) {
        getEntity(id).update(dto.getContent());
    }

    private AnswerComment getEntity(final Long id) {
        return answerCommentQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

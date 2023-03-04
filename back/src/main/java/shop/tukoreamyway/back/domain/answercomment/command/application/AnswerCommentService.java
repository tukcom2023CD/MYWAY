package shop.tukoreamyway.back.domain.answercomment.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryService;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.dto.UpdateAnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.mapper.AnswerCommentMapper;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.global.CommandService;
import shop.tukoreamyway.back.global.IdResponse;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final AnswerQueryService answerQueryService;
    private final StaffQueryService staffQueryService;
    private final AnswerCommentQueryRepository answerCommentQueryRepository;
    private final AnswerCommentMapper answerCommentMapper;

    public IdResponse<Long> create(AnswerCommentRequest dto) {
        Answer answer = answerQueryService.getEntity(dto.getAnswerId());
        Staff writer = staffQueryService.getActiveStaff(answer.getQuestion().getTeamId());
        AnswerComment answerComment =
                answerCommentRepository.save(answerCommentMapper.toEntity(dto, answer, writer));
        return new IdResponse<>(answerComment.getId());
    }

    public void update(Long id, UpdateAnswerCommentRequest dto) {
        getEntity(id).update(dto.getContent());
    }

    public void deleteById(Long id) {
        answerCommentRepository.deleteById(id);
    }

    private AnswerComment getEntity(Long id) {
        return answerCommentQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

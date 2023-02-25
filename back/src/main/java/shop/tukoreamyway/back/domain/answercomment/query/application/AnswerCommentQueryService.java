package shop.tukoreamyway.back.domain.answercomment.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class AnswerCommentQueryService implements EntityQueryService<AnswerComment, Long> {
    private final AnswerCommentQueryRepository answerCommentQueryRepository;

    public AnswerComment getEntity(Long id) {
        return answerCommentQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

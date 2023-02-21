package shop.tukoreamyway.back.domain.answercomment.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentResponse;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.mapper.AnswerCommentMapper;
import shop.tukoreamyway.back.global.QueryService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class AnswerCommentQueryService {
    private final AnswerCommentQueryRepository answerCommentQueryRepository;
    private final AnswerCommentMapper answerCommentMapper;

    public AnswerComment getEntity(Long id) {
        return answerCommentQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<AnswerCommentResponse> findAllByAnswerId(Long answerId) {
        List<AnswerComment> answerComments =
                answerCommentQueryRepository.findAllByAnswerId(answerId);
        return mapToList(answerComments);
    }

    public AnswerCommentResponse findAnswerCommentById(Long answerCommentId) {
        AnswerComment answerComment = getEntity(answerCommentId);
        return answerCommentMapper.toResponse(answerComment);
    }

    private List<AnswerCommentResponse> mapToList(List<AnswerComment> answerComments) {
        return answerComments.stream().map(answerCommentMapper::toResponse).toList();
    }
}

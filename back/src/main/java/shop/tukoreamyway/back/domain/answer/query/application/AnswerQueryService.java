package shop.tukoreamyway.back.domain.answer.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.dto.AnswerResponse;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.mapper.AnswerMapper;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class AnswerQueryService implements EntityLoader<Answer, Long> {
    private final AnswerQueryRepository answerQueryRepository;
    private final AnswerMapper answerMapper;

    public Answer getEntity(final Long id) {
        return answerQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<AnswerResponse> findAllByQuestionId(final Long memberId) {
        final List<Answer> answers = answerQueryRepository.findAllByQuestionId(memberId);
        return mapToList(answers);
    }

    public AnswerResponse findById(final Long id) {
        return answerMapper.toResponse(getEntity(id));
    }

    private List<AnswerResponse> mapToList(final List<Answer> answers) {
        return answers.stream().map(answerMapper::toResponse).toList();
    }
}

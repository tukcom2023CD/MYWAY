package shop.tukoreamyway.back.domain.answer.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class AnswerQueryService implements EntityQueryService<Answer, Long> {
    private final AnswerQueryRepository answerQueryRepository;

    public Answer getEntity(Long id) {
        return answerQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

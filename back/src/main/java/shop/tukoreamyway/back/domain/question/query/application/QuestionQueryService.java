package shop.tukoreamyway.back.domain.question.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.global.service.QueryService;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class QuestionQueryService implements EntityQueryService<Question, Long> {
    private final QuestionQueryRepository questionQueryRepository;

    public Question getEntity(Long id) {
        return questionQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}

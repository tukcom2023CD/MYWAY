package shop.tukoreamyway.back.domain.question.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.global.QueryService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@QueryService
@RequiredArgsConstructor
public class QuestionQueryService {
    private final QuestionQueryRepository questionQueryRepository;

    public Question getEntity(Long id) {
        return questionQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Question> getAllQuestion(Long memberId) {
        return questionQueryRepository.findAll(memberId);
    }

    public Optional<Question> getQuestionById(Long questionId) {
        return questionQueryRepository.findById(questionId);
    }
}

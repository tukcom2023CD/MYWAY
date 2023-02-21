package shop.tukoreamyway.back.domain.question.query.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.mapper.QuestionMapper;
import shop.tukoreamyway.back.global.QueryService;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class QuestionQueryService {
    private final QuestionQueryRepository questionQueryRepository;
    private final QuestionMapper questionMapper;

    public Question getEntity(Long id) {
        return questionQueryRepository.findQuestionById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<QuestionResponse> findAllQuestion(Long memberId) {
        List<Question> questions = questionQueryRepository.findAllQuestions(memberId);
        return mapToList(questions);
    }

    public QuestionResponse findQuestionById(Long questionId) {
        Question question = getEntity(questionId);
        return questionMapper.toResponse(question);
    }

    private List<QuestionResponse> mapToList(List<Question> questions) {
        return questions.stream().map(questionMapper::toResponse).toList();
    }
}

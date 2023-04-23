package shop.tukoreamyway.back.domain.question.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.entity.QuestionTag;
import shop.tukoreamyway.back.domain.question.entity.Tag;
import shop.tukoreamyway.back.global.service.CommandService;

import java.util.List;

@CommandService
@RequiredArgsConstructor
public class QuestionTagGenerator {

    private final TagGenerator tagGenerator;
    private final QuestionTagRepository questionTagRepository;

    public void generate(final Question question, final List<String> tags) {
        tagGenerator.generate(tags).forEach(tag -> save(question, tag));
    }

    private void save(Question question, Tag tag) {
        QuestionTag questionTag = questionTagRepository.save(new QuestionTag(question, tag));
        question.addTag(questionTag);
    }
}

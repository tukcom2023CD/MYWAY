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

    public List<QuestionTag> generate(final Question question, final List<String> tags) {
        List<Tag> tagList = tagGenerator.generate(tags);
        return tagList.stream().map(tag -> save(question, tag)).toList();
    }

    private QuestionTag save(Question question, Tag tag) {
        return questionTagRepository.save(new QuestionTag(question, tag));
    }
}

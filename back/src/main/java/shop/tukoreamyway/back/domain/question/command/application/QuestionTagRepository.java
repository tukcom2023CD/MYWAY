package shop.tukoreamyway.back.domain.question.command.application;

import shop.tukoreamyway.back.domain.question.entity.QuestionTag;

public interface QuestionTagRepository {
    QuestionTag save(QuestionTag questionTag);
}

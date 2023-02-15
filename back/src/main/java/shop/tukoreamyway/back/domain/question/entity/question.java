package shop.tukoreamyway.back.domain.question.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.answer.command.application.AnswerRepository;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.domain.question.command.application.QuestionRepository;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;
import shop.tukoreamyway.back.global.CommandService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String writer;



    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void createQuestion(Long writer) {
        Answer answer = new Answer();
    }

    public void Answe

}

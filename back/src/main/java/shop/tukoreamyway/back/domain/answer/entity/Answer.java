package shop.tukoreamyway.back.domain.answer.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Staff writer;

    public Answer(String content, Question question, Staff writer) {
        this.content = content;
        this.question = question;
        this.writer = writer;
    }
}

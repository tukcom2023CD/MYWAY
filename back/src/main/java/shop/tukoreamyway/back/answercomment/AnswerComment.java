package shop.tukoreamyway.back.answercomment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.answer.Answer;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerComment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "writer_id")
    private Staff writer;

    @Lob
    @Column(nullable = false)
    private String content;
}

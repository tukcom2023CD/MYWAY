package shop.tukoreamyway.back.domain.question.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Staff writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Team team;

    @OneToMany(mappedBy = "question")
    private List<QuestionTag> tags = new ArrayList<>();

    public Question(String title, String content, Staff writer, Team team) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.team = team;
    }
}

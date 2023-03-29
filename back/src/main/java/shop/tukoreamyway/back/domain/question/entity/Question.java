package shop.tukoreamyway.back.domain.question.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String title;

    @Lob private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Staff writer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.REMOVE)
    private final List<QuestionTag> tags = new ArrayList<>();

    @Column(nullable = false)
    private Long teamId;

    public Question(String title, String content, Staff writer, Long teamId) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.teamId = teamId;
    }

    public void update(String content) {
        this.content = content;
    }
}

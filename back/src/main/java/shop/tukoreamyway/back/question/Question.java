package shop.tukoreamyway.back.question;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.staff.domain.Staff;
import shop.tukoreamyway.back.task.domain.Task;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private Staff writer;
    private String title;
    @Lob
    private String description;
}

package shop.tukoreamyway.back.task;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String summary;
    @Lob
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Staff player;

    @ManyToOne(fetch = FetchType.LAZY)
    private Staff reviewer;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Enumerated(EnumType.STRING)
    private TaskCategory taskCategory;
}

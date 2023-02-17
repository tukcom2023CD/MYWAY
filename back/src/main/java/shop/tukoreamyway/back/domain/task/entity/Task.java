package shop.tukoreamyway.back.domain.task.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import javax.persistence.*;

@Getter
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.READY;

    @Column(nullable = false)
    private Integer contributePoint;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AbilityCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Sprint sprint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Staff player;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Staff reviewer;

    public Task(String summary, String description, AbilityCategory category, Integer contributePoint, Sprint sprint, Staff player, Staff reviewer) {
        this.summary = summary;
        this.description = description;
        this.category = category;
        this.contributePoint = contributePoint;
        this.sprint = sprint;
        this.player = player;
        this.reviewer = reviewer;
    }

    public void changePlayer(Staff staff) {
        this.player = staff;
    }
    public void changeReviewer(Staff staff) {
        this.reviewer = staff;
    }
    public void updateStatus(TaskStatus status) {
        this.status = status;
    }
}

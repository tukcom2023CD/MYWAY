package shop.tukoreamyway.back.task.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.ability.Ability;
import shop.tukoreamyway.back.staff.domain.Staff;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Ability ability;

    @ManyToOne(fetch = FetchType.LAZY)
    private Staff reviewer;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.READY;
}

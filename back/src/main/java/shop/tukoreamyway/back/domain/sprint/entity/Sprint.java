package shop.tukoreamyway.back.domain.sprint.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sprint {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Project project;
    @Column(nullable = false)
    private Integer round;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "leader_id")
    private Staff leader;

    public Sprint(Project project, Integer round, LocalDate startDate, LocalDate endDate, Staff leader) {
        this.project = project;
        this.round = round;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leader = leader;
    }
}

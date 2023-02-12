package shop.tukoreamyway.back.sprint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.project.Project;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sprint {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;

    @Column(nullable = false)
    private Integer round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "leader_id")
    private Staff leader;
}

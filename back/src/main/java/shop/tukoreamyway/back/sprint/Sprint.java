package shop.tukoreamyway.back.sprint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sprint {
    @Id
    @GeneratedValue
    private Long id;

    private Long projectId;

    @Column(nullable = false)
    private Integer round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "leader_id")
    private Staff leader;
}

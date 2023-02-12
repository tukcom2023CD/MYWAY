package shop.tukoreamyway.back.sprint;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sprint {
    @Id
    @GeneratedValue
    private Long id;

    private Long projectId;

    @Column(nullable = false)
    private Integer round;

    private Long leaderId;

    @Builder
    public Sprint(Long projectId, Integer round, Long leaderId) {
        this.projectId = projectId;
        this.round = round;
        this.leaderId = leaderId;
    }
}

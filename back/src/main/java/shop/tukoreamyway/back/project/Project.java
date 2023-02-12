package shop.tukoreamyway.back.project;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Long teamId;
    private Integer sprintDays = 7;
    private Long managerId;

    @Builder
    public Project(String name, LocalDateTime startAt, LocalDateTime endAt, Long teamId, Integer sprintDays, Long managerId) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.teamId = teamId;
        this.sprintDays = sprintDays;
        this.managerId = managerId;
    }
}

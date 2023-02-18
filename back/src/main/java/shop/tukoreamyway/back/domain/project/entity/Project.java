package shop.tukoreamyway.back.domain.project.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

import java.time.LocalDateTime;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Team team;

    @Column(nullable = false)
    private Integer sprintDays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "manager_id")
    private Staff manager;

    public Project(
            String name,
            LocalDateTime startAt,
            LocalDateTime endAt,
            Team team,
            Integer sprintDays,
            Staff manager) {
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.team = team;
        this.sprintDays = sprintDays;
        this.manager = manager;
    }
}

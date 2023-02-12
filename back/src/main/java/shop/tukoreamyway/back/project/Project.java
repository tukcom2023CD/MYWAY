package shop.tukoreamyway.back.project;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer sprintDays = 7;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "manager_id")
    private Staff manager;

}

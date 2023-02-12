package shop.tukoreamyway.back.ability;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ability {
    @Id
    @GeneratedValue
    private Long id;
    private Integer point;
    @Enumerated(EnumType.STRING)
    private AbilityCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Staff staff;
}

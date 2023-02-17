package shop.tukoreamyway.back.domain.ability.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ability {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AbilityCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private Staff receiver;

    @Column(nullable = false)
    private Long point;

    @Column(nullable = false)
    private LocalDateTime grantedAt;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GrantLocation grantLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grantor_id", nullable = false)
    private Staff grantor;

    public Ability(AbilityCategory category, Staff receiver, Long point, LocalDateTime grantedAt, GrantLocation grantLocation, Staff grantor) {
        this.category = category;
        this.receiver = receiver;
        this.point = point;
        this.grantedAt = grantedAt;
        this.grantLocation = grantLocation;
        this.grantor = grantor;
    }
}

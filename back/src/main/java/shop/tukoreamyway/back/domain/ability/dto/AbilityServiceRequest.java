package shop.tukoreamyway.back.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityServiceRequest {
    private AbilityCategory category;
    private Staff receiver;
    private Long point;
    private LocalDateTime grantedAt;
    private GrantLocation grantLocation;
    private Staff grantor;
}

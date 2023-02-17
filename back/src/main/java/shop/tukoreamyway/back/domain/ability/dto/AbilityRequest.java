package shop.tukoreamyway.back.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbilityRequest {
    private AbilityCategory category;
    private Long receiverId;
    private Long point;
    private LocalDateTime grantedAt;
    private GrantLocation grantLocation;
    private Long grantorId;
}

package shop.tukoreamyway.back.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class AbilitySummary {
    private StaffSummary receiver;
    Map<AbilityCategory, Long> points;
}
